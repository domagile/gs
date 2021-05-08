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
        setAdxNumber(number, "extractTextGroupe_chars_count");
    }


    public void setAllAfterTextOption(boolean value) {
        setCheckboxValueByLabelClick(value, "extractTextGroupe_afterInternal");
    }


    public void setAllAfterTextValue(String text) {
        setText(text, "extractTextGroupe_after_text");
    }


    public void setAllBeforeTextOption(boolean value) {
        setCheckboxValueByLabelClick(value, "extractTextGroupe_beforeInternal");
    }


    public void setAllBeforeTextValue(String text) {
        setText(text, "extractTextGroupe_before_text");
    }


    public void setMatchCase(boolean value) {
        setCheckboxValueByLabelClick(value, "extractTextGroupe_match_case");
    }


    public void setFirstCharPosition(int position) {
        setAdxNumber(position, "extractTextGroupe_by_pos_first_number");
    }


    public void setExtractedCharNumberOption(boolean value) {
        setCheckboxValueByLabelClick(value, "extractTextGroupe_by_position_charsInternal");
    }


    public void setExtractedCharNumberValue(int value) {
        setAdxNumber(value, "extractTextGroupe_by_pos_chars_number");
    }


    public void setSpecificDataType(DataTypeEnumeration dataType) {
        selectAdxComboboxValue("extractTextGroupe_links_cs", dataType.getText());
    }


    public void setMask(String mask) {
        setText(mask, "extractTextGroupe_mask_text");
    }


    public void setMaskMatchCase(boolean value) {
        setCheckboxValueByLabelClick(value, "extractTextGroupe_match_case_mask");
    }


    public void setPlaceResultsToNewColumn(boolean value) {
        setCheckboxValueByLabelClick(value, "extractTextGroupe_insert_new_column");
    }


    public void setClearExtractedText(boolean value) {
        setCheckboxValueByLabelClick(value, "extractTextGroupe_clear_source_data");
    }


    public void clickExtract() {
        clickElement("extractTextActionButton");
    }
}
