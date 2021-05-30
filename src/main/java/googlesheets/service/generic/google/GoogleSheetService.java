package googlesheets.service.generic.google;

import googlesheets.service.GlobalContext;
import googlesheets.service.generic.addon.FunctionInvocationException;
import googlesheets.service.generic.webdriver.FieldHelper;
import googlesheets.service.generic.webdriver.WebDriverService;
import googlesheets.service.generic.xpath.XPathHelper;
import googlesheets.service.technical.api.SpreadsheetService;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;
import java.util.function.BiConsumer;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static googlesheets.service.generic.addon.FunctionReinvocationUtil.invokeFunctionWithReinvocation;
import static googlesheets.service.generic.google.Credentials.LOGIN;
import static googlesheets.service.generic.google.Credentials.PASSWORD;
import static googlesheets.service.generic.webdriver.FieldHelper.*;
import static googlesheets.service.generic.webdriver.Locators.TAG_SPAN;
import static googlesheets.service.generic.webdriver.WebDriverService.openLink;
import static googlesheets.service.generic.webdriver.WebDriverService.switchDriverToDefaultContent;
import static googlesheets.service.generic.xpath.XPathHelper.*;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;


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


    public static void openSpreadsheetByName(String name) {
        String id = SpreadsheetService.getSpreadsheetIdByName(name);
        String link = String.format("https://docs.google.com/spreadsheets/d/%s/edit", id);
        openDoc(link);
    }


    public static String getSpreadsheetIdByUrl() {
        return driver.getCurrentUrl().split("/")[5];
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


    public static void deleteSpreadsheet(String spreadsheetId)
    {
        SpreadsheetService.deleteSpreadsheet(spreadsheetId);
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


    public static String getFullSheetName(String namePart) {
        switchDriverToDefaultContent();
        WebElement element = getPresentElementByXpath(textContains(namePart));
        return element.getText().trim();
    }


    public static void clickMenuItem(String menuName) {
        clickMenuItem(menuName, true);
    }

    public static void clickMenuItem(String menuName, boolean exactText) {
        invokeFunctionWithReinvocation(() -> {
            String xpath = exactText ? textIs(menuName) : textContains(menuName);
            getClickableElementByXpath(xpath).click();
        }, ElementNotInteractableException.class);
    }


    public static void clickContextMenuByText(String text) {
        getPresentElementByXpath(textIs(text)).click();
    }


    public static void removeSheetThroughMenu(String sheetName) {
        openSheetContextMenu(sheetName);
        clickContextMenuByText("Delete");
        clickDialogOK();
    }


    public static void duplicateSheetThroughMenu(String sheetName) {
        openSheetContextMenu(sheetName);
        clickContextMenuByText("Duplicate");
    }


    public static void makeSheetActive(String sheetName) {
        getElementByXpath(textIs(sheetName)).click();
        //todo: replace with some wait
        sleep(1000);
    }


    public static void clickRadioButton(String buttonId) {
        waitElementPresent(buttonId);
        //isDisplayed() returns false by some reason
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                getElement(buttonId));
    }


    public static void setPresentCheckboxValue(String checkboxId, boolean value) {
        waitElementPresent(checkboxId);
        setCheckboxValue(value, checkboxId);
    }


    public static void setCheckboxValue(boolean value, String checkboxId) {
        WebElement checkbox = getElement(checkboxId);
        if (checkbox.isSelected() != value) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        }
    }


    public static void setCheckboxValueByLabelClick(String checkboxId, boolean value) {
        WebElement checkbox = getElement(checkboxId);
        if (checkbox.isSelected() != value) {
            WebElement label = getClickableElementByAttribute("for", checkboxId);
            label.click();
        }
    }


    public static void setAngularCheckboxValue(String checkboxText, boolean value) {
        WebElement checkboxLabel = getClickableElementByXpath(textContains(checkboxText, "label"));
        boolean isSelected = checkboxLabel.getAttribute("class").contains("ui-label-active");
        if (isSelected != value) {
            checkboxLabel.click();
        }
    }


    public static void setAngularComboboxValue(int comboboxIndex, String value) {
        WebElement combobox = getElements(className("ui-dropdown-label")).get(comboboxIndex);
        String uniqueClass = Arrays.stream(combobox.getAttribute("class").split(" "))
                .filter(s -> s.startsWith("ng-tns-")).findFirst().get();
        clickElement(combobox);
        clickElement(getClickableElement(xpath(parentWithAttributeAndDescendantWithText(
                "p-dropdownitem", "class", uniqueClass, "span", value))));
    }


    public static void setAdxMultipageValue(String text) {
        WebElement label = getElementByXpath(textContains(text, "label"));
        clickElement(label);
    }


    public static void setColor(String colorTitle, String buttonDivDataTitle, String paletteDivClass) {
        clickElement(getElementByAttribute("data-title", buttonDivDataTitle));
        WebElement paletteDiv = getElementByClassName(paletteDivClass);
        clickElement(getElementByAttribute(paletteDiv, "title", colorTitle).findElement(TAG_SPAN));
    }


    public static void clickUndo() {
        clickElement(getElement("t-undo").findElement(className("goog-toolbar-button-inner-box")));
    }


    public static void clickUndo(int clickNumber) {
        for (int i = 0; i < clickNumber; i++) {
            clickUndo();
        }
    }


    public static void clickElement(String id) {
        clickElement(By.id(id));
    }


    public static void clickElementByClass(String className) {
        clickElement(className(className));
    }


    public static void clickElementByAttribute(String attribute, String value) {
        clickElement(xpath(attributeIs(attribute, value)));
    }


    public static void clickElementByText(String text) {
        clickElement(xpath(XPathHelper.textIs(text)));
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
            clickElement(adxCombobox.findElement(className("adx-custom-select-button")));
            WebElement optionsDiv = adxCombobox.findElement(className("adx-custom-select-menu"));
            if (!waitForCondition(
                    () -> optionsDiv.getCssValue("display").equals("block"),
                    2, 500)) {
                throw new FunctionInvocationException();
            }
            clickElement(optionsDiv.findElement(xpath(textIs(value))));
        }, StaleElementReferenceException.class);
    }


    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static boolean isText(String fieldId, String text) {
        return getPresentElement(fieldId).getAttribute("value").equals(text);
    }


    public static void setText(String fieldId, String text) {
        setText(() -> getPresentElement(fieldId), text);
    }


    public static void setAngularText(int elementIndex, String elementClass, String text) {
        setText(() -> FieldHelper.getElements(className(elementClass)).get(elementIndex), text);
    }


    public static void setText(Supplier<WebElement> fieldSupplier, String text) {
        invokeFunctionWithReinvocation(textValue -> {
            WebElement field = fieldSupplier.get();
            field.clear();
            field.sendKeys(textValue);
        }, text, InvalidElementStateException.class);
    }


    public static void setAdxNumber(String fieldId, int number) {
        invokeFunctionWithReinvocation(() -> {
            WebElement field = getPresentElement(fieldId);

            String currentText = field.getAttribute("value");
            StringBuilder backspaceString = new StringBuilder();
            for (int i = 0; i < currentText.length(); i++) {
                backspaceString.append(Keys.BACK_SPACE);
            }
            field.sendKeys("" + Keys.END + backspaceString);

            field.sendKeys(String.valueOf(number));
        }, InvalidElementStateException.class);
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
