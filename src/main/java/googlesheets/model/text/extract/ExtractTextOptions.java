package googlesheets.model.text.extract;

import googlesheets.model.generic.SideAddonOptions;
import googlesheets.model.text.common.enums.CharacterTypeEnumeration;
import googlesheets.model.text.extract.enums.DataTypeEnumeration;
import googlesheets.model.text.extract.enums.ExtractTypeEnumeration;

public class ExtractTextOptions implements SideAddonOptions {
    private CharacterTypeEnumeration characterType;
    private ExtractTypeEnumeration extractType;
    private int characterNumber;
    private boolean allAfterTextOption;
    private boolean allBeforeTextOption;
    private String allAfterTextValue;
    private String allBeforeTextValue;
    private boolean stringMatchCase;
    private int firstCharPosition;
    private boolean extractedCharNumberOption;
    private int extractedCharNumberValue;
    private DataTypeEnumeration specificDataType;
    private String mask;
    private boolean maskMatchCase;
    private boolean placeResultToNewColumn;
    private boolean clearExtractedText;
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

    public boolean isStringMatchCase() {
        return stringMatchCase;
    }

    public void setStringMatchCase(boolean stringMatchCase) {
        this.stringMatchCase = stringMatchCase;
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

    public boolean isPlaceResultToNewColumn() {
        return placeResultToNewColumn;
    }

    public void setPlaceResultToNewColumn(boolean placeResultToNewColumn) {
        this.placeResultToNewColumn = placeResultToNewColumn;
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

    public boolean isMaskMatchCase() {
        return maskMatchCase;
    }

    public void setMaskMatchCase(boolean maskMatchCase) {
        this.maskMatchCase = maskMatchCase;
    }
}
