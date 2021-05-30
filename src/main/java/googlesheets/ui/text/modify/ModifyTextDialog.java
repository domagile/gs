package googlesheets.ui.text.modify;

import googlesheets.model.text.modify.ModificationTypeEnumeration;

import static googlesheets.service.generic.google.GoogleSheetService.*;

public class ModifyTextDialog {
    public void setModificationType(ModificationTypeEnumeration modificationType) {
        setAdxMultipageValue(modificationType.getText());
    }


    public void setSentenceCaseRadioButton() {
        clickRadioButton("modifyGroupeChangeCaseCapitalizeEachCell");
    }


    public void setCapitalizeEachWord() {
        clickRadioButton("modifyGroupeChangeCaseCapitalizeEachWord");
    }


    public void setIgnoreAbbreviations(boolean value) {
        setCheckboxValueByLabelClick("textCapitalizeEachWordIgnoreAbbreviations", value);
    }


    public void setLowerCase() {
        clickRadioButton("modifyGroupeChangeCaseLower");
    }


    public void setUpperCase() {
        clickRadioButton("modifyGroupeChangeCaseUpper");
    }


    public void setToggleText() {
        clickRadioButton("modifyGroupeChangeCaseToggle");
    }


    public void setIgnoreFormulas(boolean value) {
        setCheckboxValueByLabelClick("textChangeCaseIgnoreFormulas", value);
    }


    public void setReplaceAccentedCharacters() {
        clickRadioButton("modifyGroupeReplaceAccentedChars");
    }


    public void setReplaceCodesWithSymbols() {
        clickRadioButton("modifyGroupeReplaceCodesSymbols_Code2Symbol");
    }


    public void setReplaceSymbolsWithCodes() {
        clickRadioButton("modifyGroupeReplaceCodesSymbols_Symbol2Code");
    }


    public void setReplaceSmartQuotesWithStraightQuotes() {
        clickRadioButton("modifyGroupeReplaceSmartQuotes_StraightQuotes");
    }


    public void setRemoveExtraSpaces(boolean value) {
        setCheckboxValueByLabelClick("textRemoveExtraSpace", value);
    }


    public void setAddSpaceAfterPunctuationMarks(boolean value) {
        setCheckboxValueByLabelClick("textAddPunctuationSpace", value);
    }


    public void setSentenceCaseCheckBox(boolean value) {
        setCheckboxValueByLabelClick("textSentenceCase", value);
    }


    public void clickRunButton() {
        clickElement("textActionButton");
    }
}
