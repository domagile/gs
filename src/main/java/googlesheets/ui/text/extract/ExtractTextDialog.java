package googlesheets.ui.text.extract;

import googlesheets.model.text.extract.enums.CharacterTypeEnumeration;
import googlesheets.model.text.extract.enums.DataTypeEnumeration;

import static googlesheets.service.generic.google.GoogleSheetService.*;

public class ExtractTextDialog {
    public void setExtractFirstLastCharacters() {
        clickRadioButton("extractTextGroupe_first_last_characters");
    }


    public void setExtractByStrings() {
        clickRadioButton("extractTextGroupe_by_strings");
    }


    public void setExtractByPosition() {
        clickRadioButton("extractTextGroupe_by_position");
    }


    public void setExtractNumbers() {
        clickRadioButton("extractTextGroupe_numbers");
    }


    public void setExtract() {
        clickRadioButton("extractTextGroupe_other");
    }


    public void setExtractByMask() {
        clickRadioButton("extractTextGroupe_by_mask");
    }


    public void setCharacterType(CharacterTypeEnumeration characterType) {
        selectAdxComboboxValue("extractTextGroupe_first_last_select_cs", characterType.getText());
    }


    public void setCharacterNumber(int number) {
        setAdxNumber("extractTextGroupe_chars_count", number);
    }


    public void setAllAfterTextOption(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_afterInternal", value);
    }


    public void setAllAfterTextValue(String text) {
        setText("extractTextGroupe_after_text", text);
    }


    public void setAllBeforeTextOption(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_beforeInternal", value);
    }


    public void setAllBeforeTextValue(String text) {
        setText("extractTextGroupe_before_text", text);
    }


    public void setMatchCase(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_match_case", value);
    }


    public void setFirstCharPosition(int position) {
        setAdxNumber("extractTextGroupe_by_pos_first_number", position);
    }


    public void setExtractedCharNumberOption(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_by_position_charsInternal", value);
    }


    public void setExtractedCharNumberValue(int value) {
        setAdxNumber("extractTextGroupe_by_pos_chars_number", value);
    }


    public void setSpecificDataType(DataTypeEnumeration dataType) {
        selectAdxComboboxValue("extractTextGroupe_links_cs", dataType.getText());
    }


    public void setMask(String mask) {
        setText("extractTextGroupe_mask_text", mask);
    }


    public void setMaskMatchCase(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_match_case_mask", value);
    }


    public void setPlaceResultsToNewColumn(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_insert_new_column", value);
    }


    public void setClearExtractedText(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_clear_source_data", value);
    }


    public void clickExtract() {
        clickElement("extractTextActionButton");
    }
}
