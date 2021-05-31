package googlesheets.ui.text.extract;

import googlesheets.model.text.common.enums.CharacterTypeEnumeration;
import googlesheets.model.text.extract.enums.*;

import static googlesheets.service.generic.google.GoogleSheetService.*;

public class ExtractTextDialog {
    public void setExtractType(ExtractTypeEnumeration extractType) {
        setAdxMultipageValue(extractType.getText());
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


    public void setMatchCaseByStrings(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_match_case", value);
    }


    public void setExtractAllOccurrencesByStrings(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_occurrences_by_strings", value);
    }


    public void setAllOccurrencesPlacementByStrings(AllOccurrencesPlacementEnumeration placement) {
        selectAdxComboboxValue("extractTextGroupe_place_by_strings", placement.getText());
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


    public void setMatchCaseByMask(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_match_case_mask", value);
    }


    public void setInsertNewColumnWithResultsByStrings(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_insert_new_column_by_strings", value);
    }


    public void setClearExtractedTextByStrings(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_clear_source_data_by_strings", value);
    }


    public void setInsertNewColumnWithResultsFirstLastCharacters(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_insert_new_column_first_last", value);
    }


    public void setClearExtractedTextFirstLastCharacters(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_clear_source_data_first_last", value);
    }


    public void setNumbersHaveSeparators(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_numbers_separators", value);
    }


    public void setDecimalSeparator(DecimalSeparatorEnumeration decimalSeparator) {
        selectAdxComboboxValue("extractTextGroupe_decimal_separator_text", decimalSeparator.getText());
    }


    public void setThousandsSeparator(ThousandsSeparatorEnumeration thousandsSeparator) {
        selectAdxComboboxValue("extractTextGroupe_thousand_separator_text", thousandsSeparator.getText());
    }


    public void setExtractAllOccurrencesNumbers(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_occurrences_numbers", value);
    }


    public void setAllOccurrencesPlacementNumbers(AllOccurrencesPlacementEnumeration placement) {
        selectAdxComboboxValue("extractTextGroupe_place_numbers", placement.getText());
    }


    public void setInsertNewColumnWithResultsNumbers(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_insert_new_column_numbers", value);
    }


    public void setClearExtractedTextNumbers(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_clear_source_data_numbers", value);
    }


    public void setInsertNewColumnWithResultsByPosition(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_insert_new_column_by_position", value);
    }


    public void setClearExtractedTextByPosition(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_clear_source_data_by_position", value);
    }


    public void setExtractAllOccurrencesLinks(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_occurrences_links", value);
    }


    public void setAllOccurrencesPlacementLinks(AllOccurrencesPlacementEnumeration placement) {
        selectAdxComboboxValue("extractTextGroupe_place_links", placement.getText());
    }


    public void setInsertNewColumnWithResultsLinks(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_insert_new_column_links", value);
    }


    public void setClearExtractedTextLinks(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_clear_source_data_links", value);
    }


    public void setExtractAllOccurrencesByMask(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_occurrences_mask", value);
    }


    public void setAllOccurrencesPlacementByMask(AllOccurrencesPlacementEnumeration placement) {
        selectAdxComboboxValue("extractTextGroupe_place_mask", placement.getText());
    }


    public void setInsertNewColumnWithResultsByMask(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_insert_new_column_mask", value);
    }


    public void setClearExtractedTextByMask(boolean value) {
        setCheckboxValueByLabelClick("extractTextGroupe_clear_source_data_mask", value);
    }


    public void clickExtract() {
        clickElement("extractTextActionButton");
    }
}
