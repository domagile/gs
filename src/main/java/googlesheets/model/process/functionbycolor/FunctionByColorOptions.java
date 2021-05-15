package googlesheets.model.process.functionbycolor;

import googlesheets.model.generic.SideAddonOptions;

public class FunctionByColorOptions implements SideAddonOptions {
    private String range;
    private String colorCell;
    private boolean fontColorOption;
    private String fontColorValue;
    private boolean backgroundColorOption;
    private String backgroundColorValue;
    private FunctionByColorEnumeration function;
    private String resultRange;
    private CalculationModeEnumeration calculationMode;
    private boolean fillResultsWithColors;


    public String getColorCell() {
        return colorCell;
    }

    public void setColorCell(String colorCell) {
        this.colorCell = colorCell;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public boolean isFontColorOption() {
        return fontColorOption;
    }

    public void setFontColorOption(boolean fontColorOption) {
        this.fontColorOption = fontColorOption;
    }

    public String getFontColorValue() {
        return fontColorValue;
    }

    public void setFontColorValue(String fontColorValue) {
        this.fontColorValue = fontColorValue;
    }

    public boolean isBackgroundColorOption() {
        return backgroundColorOption;
    }

    public void setBackgroundColorOption(boolean backgroundColorOption) {
        this.backgroundColorOption = backgroundColorOption;
    }

    public String getBackgroundColorValue() {
        return backgroundColorValue;
    }

    public void setBackgroundColorValue(String backgroundColorValue) {
        this.backgroundColorValue = backgroundColorValue;
    }

    public FunctionByColorEnumeration getFunction() {
        return function;
    }

    public void setFunction(FunctionByColorEnumeration function) {
        this.function = function;
    }

    public String getResultRange() {
        return resultRange;
    }

    public void setResultRange(String resultRange) {
        this.resultRange = resultRange;
    }

    public CalculationModeEnumeration getCalculationMode() {
        return calculationMode;
    }

    public void setCalculationMode(CalculationModeEnumeration calculationMode) {
        this.calculationMode = calculationMode;
    }

    public boolean isFillResultsWithColors() {
        return fillResultsWithColors;
    }

    public void setFillResultsWithColors(boolean fillResultsWithColors) {
        this.fillResultsWithColors = fillResultsWithColors;
    }
}
