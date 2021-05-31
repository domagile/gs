package googlesheets.model.text.extract;

import googlesheets.model.generic.SideAddonOptions;
import googlesheets.model.text.common.enums.CharacterTypeEnumeration;
import googlesheets.model.text.extract.enums.*;

public class ExtractTextOptions implements SideAddonOptions {
    private ExtractTypeEnumeration extractType;

    private boolean allAfterTextOption;
    private boolean allBeforeTextOption;
    private String allAfterTextValue;
    private String allBeforeTextValue;
    private boolean matchCase;
    private boolean extractAllOccurrences;
    private AllOccurrencesPlacementEnumeration allOccurrencesPlacement;
    private boolean insertNewColumnWithResult;
    private boolean clearExtractedText;

    private CharacterTypeEnumeration characterType;
    private int characterNumber;

    private boolean numbersHaveSeparators;
    private DecimalSeparatorEnumeration decimalSeparator;
    private ThousandsSeparatorEnumeration thousandsSeparator;

    private int firstCharPosition;
    private boolean extractedCharNumberOption;
    private int extractedCharNumberValue;

    private DataTypeEnumeration specificDataType;
    private String mask;
    private String range;

    @Override
    public String getRange() {
        return range;
    }

    @Override
    public void setRange(String range) {
        this.range = range;
    }

    public CharacterTypeEnumeration getCharacterType() {
        return characterType;
    }

    public void setCharacterType(CharacterTypeEnumeration characterType) {
        this.characterType = characterType;
    }

    public ExtractTypeEnumeration getExtractType() {
        return extractType;
    }

    public void setExtractType(ExtractTypeEnumeration extractType) {
        this.extractType = extractType;
    }

    public int getCharacterNumber() {
        return characterNumber;
    }

    public void setCharacterNumber(int characterNumber) {
        this.characterNumber = characterNumber;
    }

    public boolean isAllAfterTextOption() {
        return allAfterTextOption;
    }

    public void setAllAfterTextOption(boolean allAfterTextOption) {
        this.allAfterTextOption = allAfterTextOption;
    }

    public boolean isAllBeforeTextOption() {
        return allBeforeTextOption;
    }

    public void setAllBeforeTextOption(boolean allBeforeTextOption) {
        this.allBeforeTextOption = allBeforeTextOption;
    }

    public String getAllAfterTextValue() {
        return allAfterTextValue;
    }

    public void setAllAfterTextValue(String allAfterTextValue) {
        this.allAfterTextValue = allAfterTextValue;
    }

    public String getAllBeforeTextValue() {
        return allBeforeTextValue;
    }

    public void setAllBeforeTextValue(String allBeforeTextValue) {
        this.allBeforeTextValue = allBeforeTextValue;
    }

    public boolean isMatchCase() {
        return matchCase;
    }

    public void setMatchCase(boolean matchCase) {
        this.matchCase = matchCase;
    }

    public int getFirstCharPosition() {
        return firstCharPosition;
    }

    public void setFirstCharPosition(int firstCharPosition) {
        this.firstCharPosition = firstCharPosition;
    }

    public boolean isExtractedCharNumberOption() {
        return extractedCharNumberOption;
    }

    public void setExtractedCharNumberOption(boolean extractedCharNumberOption) {
        this.extractedCharNumberOption = extractedCharNumberOption;
    }

    public int getExtractedCharNumberValue() {
        return extractedCharNumberValue;
    }

    public void setExtractedCharNumberValue(int extractedCharNumberValue) {
        this.extractedCharNumberValue = extractedCharNumberValue;
    }

    public DataTypeEnumeration getSpecificDataType() {
        return specificDataType;
    }

    public void setSpecificDataType(DataTypeEnumeration specificDataType) {
        this.specificDataType = specificDataType;
    }

    public boolean isInsertNewColumnWithResult() {
        return insertNewColumnWithResult;
    }

    public void setInsertNewColumnWithResult(boolean insertNewColumnWithResult) {
        this.insertNewColumnWithResult = insertNewColumnWithResult;
    }

    public boolean isClearExtractedText() {
        return clearExtractedText;
    }

    public void setClearExtractedText(boolean clearExtractedText) {
        this.clearExtractedText = clearExtractedText;
    }


    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public boolean isExtractAllOccurrences() {
        return extractAllOccurrences;
    }

    public void setExtractAllOccurrences(boolean extractAllOccurrences) {
        this.extractAllOccurrences = extractAllOccurrences;
    }

    public AllOccurrencesPlacementEnumeration getAllOccurrencesPlacement() {
        return allOccurrencesPlacement;
    }

    public void setAllOccurrencesPlacement(AllOccurrencesPlacementEnumeration allOccurrencesPlacement) {
        this.allOccurrencesPlacement = allOccurrencesPlacement;
    }

    public boolean isNumbersHaveSeparators() {
        return numbersHaveSeparators;
    }

    public void setNumbersHaveSeparators(boolean numbersHaveSeparators) {
        this.numbersHaveSeparators = numbersHaveSeparators;
    }

    public DecimalSeparatorEnumeration getDecimalSeparator() {
        return decimalSeparator;
    }

    public void setDecimalSeparator(DecimalSeparatorEnumeration decimalSeparator) {
        this.decimalSeparator = decimalSeparator;
    }

    public ThousandsSeparatorEnumeration getThousandsSeparator() {
        return thousandsSeparator;
    }

    public void setThousandsSeparator(ThousandsSeparatorEnumeration thousandsSeparator) {
        this.thousandsSeparator = thousandsSeparator;
    }
}
