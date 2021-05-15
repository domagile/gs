package googlesheets.model.process.functionbycolor;

public class FunctionByColorOptionsBuilder {
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

    public FunctionByColorOptionsBuilder range(String range) {
        this.range = range;
        return this;
    }

    public FunctionByColorOptionsBuilder colorCell(String colorCell) {
        this.colorCell = colorCell;
        return this;
    }

    public FunctionByColorOptionsBuilder fontColorOption(boolean fontColorOption) {
        this.fontColorOption = fontColorOption;
        return this;
    }

    public FunctionByColorOptionsBuilder fontColorValue(String fontColorValue) {
        this.fontColorValue = fontColorValue;
        return this;
    }

    public FunctionByColorOptionsBuilder backgroundColorOption(boolean backgroundColorOption) {
        this.backgroundColorOption = backgroundColorOption;
        return this;
    }

    public FunctionByColorOptionsBuilder backgroundColorValue(String backgroundColorValue) {
        this.backgroundColorValue = backgroundColorValue;
        return this;
    }

    public FunctionByColorOptionsBuilder function(FunctionByColorEnumeration function) {
        this.function = function;
        return this;
    }

    public FunctionByColorOptionsBuilder resultRange(String resultRange) {
        this.resultRange = resultRange;
        return this;
    }

    public FunctionByColorOptionsBuilder calculationMode(CalculationModeEnumeration calculationMode) {
        this.calculationMode = calculationMode;
        return this;
    }

    public FunctionByColorOptionsBuilder fillResultsWithColors(boolean fillResultsWithColors) {
        this.fillResultsWithColors = fillResultsWithColors;
        return this;
    }

    public FunctionByColorOptions build() {
        FunctionByColorOptions options = new FunctionByColorOptions();
        options.setRange(range);
        options.setColorCell(colorCell);
        options.setFontColorOption(fontColorOption);
        options.setFontColorValue(fontColorValue);
        options.setBackgroundColorOption(backgroundColorOption);
        options.setBackgroundColorValue(backgroundColorValue);
        options.setFunction(function);
        options.setResultRange(resultRange);
        options.setCalculationMode(calculationMode);
        options.setFillResultsWithColors(fillResultsWithColors);
        return options;
    }
}