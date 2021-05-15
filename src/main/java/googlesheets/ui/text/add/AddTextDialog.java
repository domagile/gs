package googlesheets.ui.text.add;

import googlesheets.model.text.add.AddTextOptions;

import static googlesheets.service.generic.google.GoogleSheetService.*;

public class AddTextDialog {
    public void setAddedText(String text) {
        setText("addTextGroupe_Text", text);
    }


    public void setPosition(AddTextOptions options) {
        switch (options.getPosition()) {
            case BEGINNING:
                setPositionBeginning();
                break;
            case END:
                setPositionEnd();
                break;
            case AFTER_CHARACTER_NUMBER:
                setPositionAfterCharacterNumber();
                setCharacterNumber(options.getCharacterNumber());
                break;
            case BEFORE_TEXT:
                setPositionBeforeText();
                setBeforeText(options.getPositionText());
                break;
            case AFTER_TEXT:
                setPositionAfterText();
                setAfterText(options.getPositionText());
                break;
            default:
                throw new IllegalStateException("Unknown position " + options.getPosition());
        }
    }


    private void setPositionBeginning() {
        clickRadioButton("addTextGroupe_find_by_position_type_begin");
    }


    private void setPositionEnd() {
        clickRadioButton("addTextGroupe_find_by_position_type_end");
    }


    private void setPositionAfterCharacterNumber() {
        clickRadioButton("addTextGroupe_find_by_position_type_charter");
    }


    private void setPositionBeforeText() {
        clickRadioButton("addTextGroupe_find_by_position_type_before");
    }


    private void setPositionAfterText() {
        clickRadioButton("addTextGroupe_find_by_position_type_after");
    }


    public void setCharacterNumber(int number) {
        setAdxNumber("addTextGroupe_find_by_position_position", number);
    }


    public void setBeforeText(String text) {
        setText("addTextGroupe_find_by_character_before_text", text);
    }


    public void setAfterText(String text) {
        setText("addTextGroupe_find_by_character_after_text", text);
    }


    public void setSkipEmptyCells(boolean value)
    {
        setCheckboxValueByLabelClick("addTextGroupe_skip_empty_cells", value);
    }


    public void clickRun()
    {
        clickElement("textAddActionButton");
    }
}
