package googlesheets.service.generic.google;

import googlesheets.service.EntityList;
import googlesheets.service.GlobalContext;
import googlesheets.service.generic.WebDriverService;
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
import static googlesheets.service.generic.xpath.XPathHelper.*;


public class GoogleSheetService {
    private static final WebDriver driver = WebDriverService.getInstance().getDriver();
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();


    public static void openDoc(String link) {
        if (GlobalContext.USE_CUSTOM_LINKS) {
            link = getCustomLink(link);
        }
        driver.get(link);
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

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("identifierId")));
        driver.findElement(By.id("identifierId")).sendKeys(LOGIN);
        driver.findElement(By.id("identifierNext")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
        driver.findElement(By.name("password")).sendKeys(PASSWORD);
        driver.findElement(By.id("passwordNext")).click();
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
            wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
            driver.findElement(elementLocator).click();
        }, locator, InvalidElementStateException.class);
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


    public static void waitElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }


    public static void waitText(String text) {
        By xpath = By.xpath(textContains(text));
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
    }


    public static void clickDialogOK() {
        clickElement(By.name("ok"));
    }


    public static void openSheetContextMenu(String sheetName) {
        invokeFunctionWithReinvocation(name -> {
            Actions actions = new Actions(driver);
            By xpath = By.xpath(textIs(name));
            wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
            WebElement element = driver.findElement(xpath);
            actions.contextClick(element).perform();
        }, sheetName, StaleElementReferenceException.class);
    }


    public static String getResultListName(String namePart) {
        driver.switchTo().defaultContent();

        By xpath = By.xpath(textContains(namePart));
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
        WebElement element = driver.findElement(xpath);
        return element.getText().trim();
    }


    public static void clickContextMenuByText(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(textIs(text))));
        driver.findElement(By.xpath(textIs(text))).click();
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
        By xpath = By.xpath(textIs(sheetName));
        driver.findElement(xpath).click();
        //todo: replace with some wait
        sleep(1000);
    }


    public static void clickAddonsMenu() {
        invokeFunctionWithReinvocation(() -> {
            By addonsMenuLocator = By.xpath(textIs("Add-ons"));
            wait.until(ExpectedConditions.elementToBeClickable(addonsMenuLocator));
            driver.findElement(addonsMenuLocator).click();
        }, ElementClickInterceptedException.class, UnhandledAlertException.class);
    }


    public static void clickMenuItem(String menuName) {
        clickMenuItem(menuName, true);
    }

    public static void clickMenuItem(String menuName, boolean exactText) {
        invokeFunctionWithReinvocation((menu, text) -> {
            String xpath = exactText ? textIs(menuName) : textContains(menuName);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            driver.findElement(By.xpath(xpath)).click();
        }, menuName, exactText, ElementNotInteractableException.class);
    }


    public static void clickHighLevelMenuItem(String menuName, String nextMenuName) {
        clickHighLevelMenuItem(menuName, nextMenuName, true);
    }

    public static void clickHighLevelMenuItem(String menuName, String nextMenuName, boolean exactText) {
        String xpath = exactText ? "//*[text()='" + menuName + "']" : "//*[text()[contains(.,'" + menuName + "')]]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
        try {
            xpath = exactText ? "//*[text()='" + nextMenuName + "']" : "//*[text()[contains(.,'" + nextMenuName + "')]]";
            //element is not clickable at least at AFR by some reason
//            wait.withTimeout(Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            wait.withTimeout(Duration.ofSeconds(2)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        } catch (TimeoutException e) {
            //fixme: repeat invocation only 1 time
            clickHighLevelMenuItem(menuName, nextMenuName, exactText);
        } finally {
            WebDriverService.getInstance().resetWaitTimeout();
        }
    }

    public static void clickRadioButton(String buttonId) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(buttonId)));
        //isDisplayed() returns false by some reason
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                driver.findElement(By.id(buttonId)));
    }


    public static void setCheckboxValue(boolean value, String checkboxId) {
        WebElement checkbox = driver.findElement(By.id(checkboxId));
        if (checkbox.isSelected() != value) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        }
    }


    public static void clickUndo() {
        driver.findElement(By.id("t-undo")).findElement(By.className("goog-toolbar-button-inner-box")).click();
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
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(tableBodyId)));
            WebElement tBody = driver.findElement(By.id(tableBodyId));
            List<WebElement> trs = tBody.findElements(By.tagName("tr"));
            //if list is loaded during long time
            while (trs.isEmpty()) {
                sleep(1000);
                trs = tBody.findElements(By.tagName("tr"));
            }
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


    public static void clickElement(String id) {
        clickElement(By.id(id));
    }


    public static void selectComboboxValue(String id, String value) {
            WebElement select = driver.findElement(By.id(id));
            selectComboboxValue(select, value);
    }


    public static void selectComboboxValue(WebElement select, String value) {
        invokeFunctionWithReinvocation((selectParam, valueParam) -> {
                    Select combobox = new Select(selectParam);
                    combobox.selectByVisibleText(valueParam);
                }, select, value,
                StaleElementReferenceException.class, ElementNotInteractableException.class, NoSuchElementException.class);

    }


    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void setText(String text, String fieldId) {
        invokeFunctionWithReinvocation(textValue -> {
            By fieldLocator = By.id(fieldId);
            wait.until(ExpectedConditions.presenceOfElementLocated(fieldLocator));
            driver.findElement(fieldLocator).clear();
            driver.findElement(fieldLocator).sendKeys(textValue);
        }, text, ElementNotInteractableException.class);
    }


    public static void checkText(String text, String fieldId, Consumer<String> setTextFunction) {
        By fieldLocator = By.id(fieldId);
        wait.until(ExpectedConditions.presenceOfElementLocated(fieldLocator));
        String currentText = driver.findElement(fieldLocator).getAttribute("value");
        if (!currentText.equals(text)) {
            setTextFunction.accept(text);
        }
    }


    public static void checkText(String text, String fieldId, BiConsumer<String, String> setTextFunction) {
        By fieldLocator = By.id(fieldId);
        wait.until(ExpectedConditions.presenceOfElementLocated(fieldLocator));
        String currentText = driver.findElement(fieldLocator).getAttribute("value");
        if (!currentText.equals(text)) {
            setTextFunction.accept(text, fieldId);
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
