package googlesheets.model.text.extract;

import googlesheets.model.text.common.enums.CharacterTypeEnumeration;
import googlesheets.model.text.extract.enums.*;

public class ExtractTextOptionBuilder {
    private String range;
    private CharacterTypeEnumeration characterType;
    private ExtractTypeEnumeration extractType;
    private int characterNumber;
    private boolean allAfterTextOption;
    private boolean allBeforeTextOption;
    private String allAfterTextValue;
    private String allBeforeTextValue;
    private boolean matchCase;
    private int firstCharPosition;
    private boolean extractedCharNumberOption;
    private int extractedCharNumberValue;
    private DataTypeEnumeration specificDataType;
    private String mask;
    private boolean placeResultToNewColumn;
    private boolean clearExtractedText;
    private boolean extractAllOccurrences;
    private AllOccurrencesPlacementEnumeration allOccurrencesPlacement;
    private boolean numbersHaveSeparators;
    private DecimalSeparatorEnumeration decimalSeparator;
    private ThousandsSeparatorEnumeration thousandsSeparator;


    public ExtractTextOptionBuilder extractAllOccurrences(boolean extractAllOccurrences) {
        this.extractAllOccurrences = extractAllOccurrences;
        return this;
    }

    public ExtractTextOptionBuilder allOccurrencesPlacement(AllOccurrencesPlacementEnumeration allOccurrencesPlacement) {
        this.allOccurrencesPlacement = allOccurrencesPlacement;
        return this;
    }

    public ExtractTextOptionBuilder numbersHaveSeparators(boolean numbersHaveSeparators) {
        this.numbersHaveSeparators = numbersHaveSeparators;
        return this;
    }

    public ExtractTextOptionBuilder decimalSeparator(DecimalSeparatorEnumeration decimalSeparator) {
        this.decimalSeparator = decimalSeparator;
        return this;
    }

    public ExtractTextOptionBuilder thousandsSeparator(ThousandsSeparatorEnumeration thousandsSeparator) {
        this.thousandsSeparator = thousandsSeparator;
        return this;
    }

    public ExtractTextOptionBuilder range(String range) {
        this.range = range;
        return this;
    }

    public ExtractTextOptionBuilder characterType(CharacterTypeEnumeration characterType) {
        this.characterType = characterType;
        return this;
    }

    public ExtractTextOptionBuilder extractType(ExtractTypeEnumeration extractType) {
        this.extractType = extractType;
        return this;
    }

    public ExtractTextOptionBuilder characterNumber(int characterNumber) {
        this.characterNumber = characterNumber;
        return this;
    }

    public ExtractTextOptionBuilder allAfterTextOption(boolean allAfterTextOption) {
        this.allAfterTextOption = allAfterTextOption;
        return this;
    }

    public ExtractTextOptionBuilder allBeforeTextOption(boolean allBeforeTextOption) {
        this.allBeforeTextOption = allBeforeTextOption;
        return this;
    }

    public ExtractTextOptionBuilder allAfterTextValue(String allAfterTextValue) {
        this.allAfterTextValue = allAfterTextValue;
        return this;
    }

    public ExtractTextOptionBuilder allBeforeTextValue(String allBeforeTextValue) {
        this.allBeforeTextValue = allBeforeTextValue;
        return this;
    }

    public ExtractTextOptionBuilder matchCase(boolean matchCase) {
        this.matchCase = matchCase;
        return this;
    }

    public ExtractTextOptionBuilder firstCharPosition(int firstCharPosition) {
        this.firstCharPosition = firstCharPosition;
        return this;
    }

    public ExtractTextOptionBuilder extractedCharNumberOption(boolean extractedCharNumberOption) {
        this.extractedCharNumberOption = extractedCharNumberOption;
        return this;
    }

    public ExtractTextOptionBuilder extractedCharNumberValue(int extractedCharNumberValue) {
        this.extractedCharNumberValue = extractedCharNumberValue;
        return this;
    }

    public ExtractTextOptionBuilder specificDataType(DataTypeEnumeration specificDataType) {
        this.specificDataType = specificDataType;
        return this;
    }

    public ExtractTextOptionBuilder mask(String mask) {
        this.mask = mask;
        return this;
    }

    public ExtractTextOptionBuilder placeResultToNewColumn(boolean placeResultToNewColumn) {
        this.placeResultToNewColumn = placeResultToNewColumn;
        return this;
    }

    public ExtractTextOptionBuilder clearExtractedText(boolean clearExtractedText) {
        this.clearExtractedText = clearExtractedText;
        return this;
    }




    public ExtractTextOptions build() {
        ExtractTextOptions options = new ExtractTextOptions();
        options.setRange(range);
        options.setCharacterType(characterType);
        options.setExtractType(extractType);
        options.setCharacterNumber(characterNumber);
        options.setAllAfterTextOption(allAfterTextOption);
        options.setAllBeforeTextOption(allBeforeTextOption);
        options.setAllAfterTextValue(allAfterTextValue);
        options.setAllBeforeTextValue(allBeforeTextValue);
        options.setMatchCase(matchCase);
        options.setFirstCharPosition(firstCharPosition);
        options.setExtractedCharNumberOption(extractedCharNumberOption);
        options.setExtractedCharNumberValue(extractedCharNumberValue);
        options.setSpecificDataType(specificDataType);
        options.setMask(mask);
        options.setInsertNewColumnWithResult(placeResultToNewColumn);
        options.setClearExtractedText(clearExtractedText);
        options.setExtractAllOccurrences(extractAllOccurrences);
        options.setAllOccurrencesPlacement(allOccurrencesPlacement);
        options.setNumbersHaveSeparators(numbersHaveSeparators);
        options.setDecimalSeparator(decimalSeparator);
        options.setThousandsSeparator(thousandsSeparator);
        return options;
    }
}