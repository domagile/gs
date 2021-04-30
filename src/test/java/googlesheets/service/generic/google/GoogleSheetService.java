package googlesheets.service.generic.google;

import googlesheets.model.generic.rowselection.PairSelection;
import googlesheets.model.generic.rowselection.TripleSelection;
import googlesheets.service.GlobalContext;
import googlesheets.service.generic.addon.FunctionInvocationException;
import googlesheets.service.generic.webdriver.WebDriverService;
import googlesheets.service.generic.addon.sheetselection.EntityList;
import googlesheets.service.generic.xpath.XPathHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.function.BiConsumer;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

import static googlesheets.service.generic.addon.GenericAddonService.invokeFunctionWithReinvocation;
import static googlesheets.service.generic.google.Credentials.LOGIN;
import static googlesheets.service.generic.google.Credentials.PASSWORD;
import static googlesheets.service.generic.webdriver.FieldHelper.*;
import static googlesheets.service.generic.webdriver.Locators.*;
import static googlesheets.service.generic.webdriver.WebDriverService.*;
import static googlesheets.service.generic.xpath.XPathHelper.*;


public class GoogleSheetService {
    private static final WebDriver driver = WebDriverService.getInstance().getDriver();
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();


    public static void openDoc(String link) {
        if (GlobalContext.USE_CUSTOM_LINKS) {
            link = getCustomLink(link);
        }
        openLink(link);
        login();
    }


    private static String getCustomLink(String link) {
        Properties customLinkMapping = new Properties();
        String commonPart = link.substring(0, link.indexOf('#'));
        String propertiesFileName = "\\googlesheets\\test\\custom_links.properties";

        try {
            customLinkMapping.load(GoogleSheetService.class.getClassLoader().getResourceAsStream(propertiesFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Optional<Object> first = customLinkMapping.values().stream()
                .filter(customLink -> ((String) customLink).contains(commonPart)).findFirst();
        if (!first.isPresent())
            throw new RuntimeException("Custom link was not found");
        return (String) first.get();
    }


    public static void login() {
        if (GlobalContext.getInstance().isLoggedIn())
            return;

        waitElementPresent("identifierId");
        getElement("identifierId").sendKeys(LOGIN);
        getElement("identifierNext").click();

        waitElementClickableByName("password");
        getElementByName("password").sendKeys(PASSWORD);
        getElement("passwordNext").click();
        //todo: if window with second authorization then: choose confirmation with second mail, enter second mail
        //todo: if "Protect your account" window then press Confirm

        GlobalContext.getInstance().setLoggedIn(true);

        //let document to load
        sleep(5000);
    }


    public static void startCSVDownload() {
        clickMenuFile();
        clickMenuDownload();
        clickElement(By.xpath(attributeIs("aria-label", "Comma-separated values (.csv, current sheet) c")));
    }

    private static void clickMenuDownload() {
        clickElement(By.xpath(attributeIs("aria-label", "Download d")));
    }

    private static void clickMenuFile() {
        clickElement(By.xpath(textIs("File")));
    }

    public static void startXLSXDownload() {
        clickMenuFile();
        clickMenuDownload();
        clickElement(By.xpath(attributeIs("aria-label", "Microsoft Excel (.xlsx) x")));
    }

    public static void moveSpreadsheetToTrash() {
        clickMenuFile();
        clickElement(By.xpath(attributeIs("aria-label", "Move to trash t")));
    }

    public static void clickElement(By locator) {
        invokeFunctionWithReinvocation(elementLocator -> {
            getClickableElement(elementLocator).click();
        }, locator, InvalidElementStateException.class);
    }

    public static void clickElement(WebElement webElement) {
        invokeFunctionWithReinvocation(element -> {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }, webElement, InvalidElementStateException.class);
    }


    public static void clearFieldWithCtrlADel(WebElement field) {
        field.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }


    public static void clearFieldWithEndShiftHomeBackspace(WebElement field) {
        Actions actions = new Actions(driver);
        actions.click(field)
                .sendKeys(Keys.END)
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.HOME)
                .keyUp(Keys.SHIFT)
                .sendKeys(Keys.BACK_SPACE)
                .perform();
    }


    public static void replaceTextWith(String text, WebElement field) {
        String oldText = field.getText();
        StringBuilder inputString = new StringBuilder(text);
        for (int i = 0; i < text.length(); i++) {
            inputString.append(Keys.ARROW_LEFT);
        }
        for (int i = 0; i < oldText.length(); i++) {
            inputString.append(Keys.BACK_SPACE);
        }
        field.sendKeys(inputString.toString());
    }


    public static void waitText(String text) {
        waitElementPresentByXpath(textContains(text));
    }


    public static void clickDialogOK() {
        clickElement(By.name("ok"));
    }


    public static void openSheetContextMenu(String sheetName) {
        invokeFunctionWithReinvocation(name -> {
            Actions actions = new Actions(driver);
            WebElement element = getPresentElementByXpath(textIs(name));
            actions.contextClick(element).perform();
        }, sheetName, StaleElementReferenceException.class);
    }


    public static String getResultListName(String namePart) {
        switchDriverToDefaultContent();
        WebElement element = getPresentElementByXpath(textContains(namePart));
        return element.getText().trim();
    }


    public static void clickContextMenuByText(String text) {
        getPresentElementByXpath(textIs(text)).click();
    }


    public static void removeListThroughMenu(String listName) {
        openSheetContextMenu(listName);
        clickContextMenuByText("Delete");
        clickDialogOK();
    }


    public static void duplicateListThroughMenu(String listName) {
        openSheetContextMenu(listName);
        clickContextMenuByText("Duplicate");
    }


    public static void makeSheetActive(String sheetName) {
        getElementByXpath(textIs(sheetName)).click();
        //todo: replace with some wait
        sleep(1000);
    }


    public static void clickAddonsMenu() {
        invokeFunctionWithReinvocation(() -> {
            getClickableElementByXpath(textIs("Add-ons")).click();
        }, ElementClickInterceptedException.class, UnhandledAlertException.class);
    }


    public static void clickMenuItem(String menuName) {
        clickMenuItem(menuName, true);
    }

    public static void clickMenuItem(String menuName, boolean exactText) {
        invokeFunctionWithReinvocation((menu, text) -> {
            String xpath = exactText ? textIs(menuName) : textContains(menuName);
            getClickableElementByXpath(xpath).click();
        }, menuName, exactText, ElementNotInteractableException.class);
    }


    public static void clickHighLevelMenuItem(String menuName, String nextMenuName) {
        clickHighLevelMenuItem(menuName, nextMenuName, true);
    }

    public static void clickHighLevelMenuItem(String menuName, String nextMenuName, boolean exactText) {
        invokeFunctionWithReinvocation(() -> {
            String xpath = exactText ? textIs(menuName) : textContains(menuName);
            getPresentElementByXpath(xpath).click();
            xpath = exactText ? textIs(nextMenuName) : textContains(nextMenuName);
            getWaitWithTimeout(2).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        }, TimeoutException.class);
    }

    public static void clickRadioButton(String buttonId) {
        waitElementPresent(buttonId);
        //isDisplayed() returns false by some reason
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                getElement(buttonId));
    }


    public static void setPresentCheckboxValue(boolean value, String checkboxId) {
        waitElementPresent(checkboxId);
        setCheckboxValue(value, checkboxId);
    }


    public static void setCheckboxValue(boolean value, String checkboxId) {
        WebElement checkbox = getElement(checkboxId);
        if (checkbox.isSelected() != value) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        }
    }


    public static void setCheckboxValueByLabelClick(boolean value, String checkboxId) {
        WebElement checkbox = getElement(checkboxId);
        if (checkbox.isSelected() != value) {
            WebElement label = getClickableElementByAttribute("for", checkboxId);
            label.click();
        }
    }


    public static void clickUndo() {
        getElement("t-undo").findElement(By.className("goog-toolbar-button-inner-box")).click();
    }


    public static void clickUndo(int clickNumber) {
        for (int i = 0; i < clickNumber; i++) {
            clickUndo();
        }
    }


    public static void selectRowsInTable(String tableBodyId, By checkboxLocator, Integer... indexes) {
        selectRowsInTable(tableBodyId, checkboxLocator, Arrays.asList(indexes));
    }


    public static void selectRowsInTable(String tableBodyId, By checkboxLocator, List<Integer> indexes) {
        try {
            List<WebElement> trs = getTableTRs(tableBodyId);
            EntityList columns = new EntityList(trs, 0);
            for (int i = 0; i < trs.size(); i++) {
                columns.selectEntity(i, indexes.contains(i + 1), checkboxLocator);
            }
        }
        //when tBody is reloaded by browser and link is not actual
        catch (StaleElementReferenceException e) {
            selectRowsInTable(tableBodyId, checkboxLocator, indexes);
        }
    }


    public static void selectPairsInTable(String tableBodyId, List<PairSelection<Integer, String>> pairs, int stringColumnIndex) {
        try {
            List<WebElement> trs = getTableTRs(tableBodyId);
            EntityList columns = new EntityList(trs, 0);
            By comboboxLocator = TAG_SELECT;
            for (PairSelection<Integer, String> pair : pairs) {
                columns.selectEntity(pair.getFirst() - 1, true, TAG_INPUT);
                columns.setComboboxValue(pair.getFirst() - 1, stringColumnIndex, pair.getSecond(), comboboxLocator);
            }
        }
        //when tBody is reloaded by browser and link is not actual
        catch (StaleElementReferenceException e) {
            selectPairsInTable(tableBodyId, pairs, stringColumnIndex);
        }
    }

    public static void selectTriplesInTable(String tableBodyId, List<TripleSelection<Integer, String, String>> triples,
                                            int firstStringColumnIndex, int secondStringColumnIndex) {
        try {
            List<WebElement> trs = getTableTRs(tableBodyId);
            clearSelection(triples, trs);
            By comboboxLocator = TAG_SELECT;
            EntityList columns = new EntityList(trs, 0);
            for (TripleSelection<Integer, String, String> triple : triples) {
                columns.selectEntity(triple.getFirst() - 1, true, TAG_INPUT);
                columns.setComboboxValue(triple.getFirst() - 1, firstStringColumnIndex, triple.getSecond(), comboboxLocator);
                if (triple.getThird() != null) {
                    columns.setComboboxValue(triple.getFirst() - 1, secondStringColumnIndex, triple.getThird(), comboboxLocator);
                }
            }
        }
        //when tBody is reloaded by browser and link is not actual
        catch (StaleElementReferenceException e) {
            selectTriplesInTable(tableBodyId, triples, firstStringColumnIndex, secondStringColumnIndex);
        }
    }

    private static void clearSelection(List<TripleSelection<Integer, String, String>> triples, List<WebElement> trs) {
        for (int i = 0; i < trs.size(); i++) {
            List<WebElement> inputs = trs.get(i).findElements(TAG_TD).get(0).findElements(TAG_INPUT);
            if (!inputs.isEmpty()) {
                WebElement checkbox = inputs.get(0);
                if (checkbox.isSelected() && !isTripleWithIndexPresent(triples, i)) {
                    //checkbox isDisplayed is false and its not interactable here
                    List<WebElement> clickableCheckboxImages = trs.get(i).findElements(TAG_TD).get(0).findElements(
                            By.className("adx-checkbox-square-image"));
                    clickableCheckboxImages.get(0).click();
                }
            }
        }
    }

    private static boolean isTripleWithIndexPresent(List<TripleSelection<Integer, String, String>> triples, int index) {
        return triples.stream().map(TripleSelection::getFirst).anyMatch(i -> i - 1 == index);
    }

    private static List<WebElement> getTableTRs(String tableBodyId) {
        WebElement tBody = getPresentElement(tableBodyId);
        List<WebElement> trs = tBody.findElements(TAG_TR);
        //if list is loaded during long time
        while (trs.isEmpty()) {
            sleep(1000);
            trs = tBody.findElements(TAG_TR);
        }
        return trs;
    }


    public static void clickElement(String id) {
        clickElement(By.id(id));
    }


    public static void clickElementByClass(String className) {
        clickElement(By.className(className));
    }


    public static void clickElementByAttribute(String attribute, String value) {
        clickElement(By.xpath(XPathHelper.attributeIs(attribute, value)));
    }


    public static void clickElementByText(String text) {
        clickElement(By.xpath(XPathHelper.textIs(text)));
    }


    public static void selectComboboxValue(String id, String value) {
        try {
            WebElement select = getElement(id);
            selectComboboxValue(select, value);
        } catch (StaleElementReferenceException e) {
            sleep(1000);
            selectComboboxValue(id, value);
        }
    }


    public static void selectComboboxValue(WebElement select, String value) {
        invokeFunctionWithReinvocation(() -> {
            Select combobox = new Select(select);
            combobox.selectByVisibleText(value);
        }, ElementNotInteractableException.class, NoSuchElementException.class);
    }


    public static void selectAdxComboboxValue(String id, String value) {
        invokeFunctionWithReinvocation(() -> {
            WebElement adxCombobox = getElement(id);
            clickElement(adxCombobox.findElement(By.className("adx-custom-select-button")));
            if (!waitForCondition(
                    () -> adxCombobox.findElement(By.className("adx-custom-select-menu")).getCssValue("display").equals("block"),
                    2, 500)) {
                throw new FunctionInvocationException();
            }
            clickElement(adxCombobox.findElement(By.xpath(textIs(value))));
        }, StaleElementReferenceException.class);
    }


    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static boolean isText(String text, String fieldId) {
        return getPresentElement(fieldId).getAttribute("value").equals(text);
    }


    public static void setText(String text, String fieldId) {
        invokeFunctionWithReinvocation(textValue -> {
            WebElement field = getPresentElement(fieldId);
            field.clear();
            field.sendKeys(textValue);
        }, text, InvalidElementStateException.class);
    }


    public static void checkText(String text, String fieldId, Consumer<String> setTextFunction) {
        String currentText = getPresentElement(fieldId).getAttribute("value");
        if (!currentText.equals(text)) {
            setTextFunction.accept(text);
        }
    }


    public static void checkText(String text, String fieldId, BiConsumer<String, String> setTextFunction) {
        String currentText = getPresentElement(fieldId).getAttribute("value");
        if (!currentText.equals(text)) {
            setTextFunction.accept(text, fieldId);
        }
    }


    public static void checkText(String text, WebElement element, BiConsumer<WebElement, String> setTextFunction) {
        String currentText = element.getAttribute("value");
        if (!currentText.equals(text)) {
            //todo: throw exception to trigger reinvocation
            sleep(1000);
            setTextFunction.accept(element, text);
        }
    }


    public static boolean waitForCondition(BooleanSupplier condition, int checkNumber, int pauseMillis) {
        for (int i = 0; i < checkNumber; i++) {
            if (condition.getAsBoolean()) {
                return true;
            } else {
                sleep(pauseMillis);
            }
        }
        return false;
    }
}
