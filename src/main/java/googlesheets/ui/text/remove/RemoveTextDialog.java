package googlesheets.ui.text.remove;

import googlesheets.model.text.common.enums.CharacterTypeEnumeration;
import googlesheets.model.text.remove.RemovalTypeEnumeration;
import googlesheets.model.text.remove.TextPositionEnumeration;
import googlesheets.service.generic.google.GoogleSheetService;

import java.util.List;

import static googlesheets.service.generic.google.GoogleSheetService.*;

public class RemoveTextDialog {
    public void setRemovalType(RemovalTypeEnumeration removalType) {
        setAdxMultipageValue(removalType.getText());
    }


    public void setRemoveSubstrings() {
        clickRadioButton("removeSubstrings");
    }


    public void setRemoveCharacters() {
        clickRadioButton("removeEnteredChars");
    }


    public void setSubstrings(List<String> substrings) {
        setText("removeSubstringsTextarea", String.join("\n", substrings));
    }


    public void setSubstringsMatchCase(boolean value) {
        setCheckboxValueByLabelClick("removeSubstringsMatchCase", value);
    }


    public void setCharacters(String characters) {
        setText("removeEnteredCharsInput", characters);
    }


    public void setRemoveLeadingTrailingSpaces(boolean value) {
        setCheckboxValueByLabelClick("removeLeadAndTrailSpaces", value);
    }


    public void setRemoveSpacesBetweenWordsToOne(boolean value) {
        setCheckboxValueByLabelClick("removeSpacesBetweenWordsToOne", value);
    }


    public void setRemoveAllSpaces(boolean value) {
        setCheckboxValueByLabelClick("removeAllSpaces", value);
    }


    public void setRemoveLineBreaks(boolean value) {
        setCheckboxValueByLabelClick("removeLineBreak", value);
    }


    public void setRemoveHtmlEntities(boolean value) {
        setCheckboxValueByLabelClick("removeNbsp", value);
    }


    public void setRemoveHtmlTags(boolean value) {
        setCheckboxValueByLabelClick("removeTags", value);
    }


    public void setRemoveAllDelimiters(boolean value) {
        setCheckboxValueByLabelClick("removeAllDelimiters", value);
    }


    public void setRemoveNonPrintingCharacters(boolean value) {
        setCheckboxValueByLabelClick("removeNonPrintChars", value);
    }


    public void setRemoveCharactersByPosition() {
        clickRadioButton("removeAllChars");
    }


    public void setRemoveFirstLastCharacters() {
        clickRadioButton("removeFirstOrLastCharsByCount");
    }


    public void setRemoveCharactersBeforeAfterText() {
        clickRadioButton("removeEverythingBeforeAfterText");
    }


    public void setFromPosition(int position) {
        setAdxNumber("removeAllCharsFrom", position);
    }


    public void setToPosition(int position) {
        setAdxNumber("removeAllCharsTo", position);
    }


    public void setCharacterType(CharacterTypeEnumeration characterType) {
        selectComboboxValue("removeFirstOrLastCharsInput", characterType.getText());
    }


    public void setCharacterNumber(int number) {
        setAdxNumber("removeCharsCount", number);
    }


    public void setTextPosition(TextPositionEnumeration textPosition) {
        selectComboboxValue("removeEverythingBeforeAfterTextInput", textPosition.getText());
    }


    public void setBeforeAfterText(String text) {
        setText("removeText", text);
    }


    public void setTextMatchCase(boolean value) {
        setCheckboxValueByLabelClick("removeEverythingBeforeAfterMatchCase", value);
    }


    public void clickRemoveButton() {
        clickElement("removeActionButton");
    }
}
