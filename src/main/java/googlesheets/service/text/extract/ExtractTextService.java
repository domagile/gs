package googlesheets.service.text.extract;

import googlesheets.model.text.extract.ExtractTextOptions;
import googlesheets.service.generic.addon.SideAddonService;
import googlesheets.ui.text.extract.ExtractTextDialog;

import static googlesheets.service.generic.addon.GenericAddonService.*;

public class ExtractTextService implements SideAddonService<ExtractTextOptions> {
    private ExtractTextDialog addonDialog = new ExtractTextDialog();

    public void runAddon()
    {
        new ExtractTextRunner().runAddon();
    }

    public void selectRange(String range) {
        setNameBoxValue(range);
    }

    public void setOptions(ExtractTextOptions options) {
        switch (options.getExtractType()) {
            case FIRST_LAST_CHARACTERS:
                setExtractFirstLastCharactersOptions(options);
                break;
            case BY_STRINGS:
                setExtractByStringsOptions(options);
                break;
            case BY_POSITION:
                setExtractByPositionOptions(options);
                break;
            case NUMBERS:
                addonDialog.setExtractNumbers();
                break;
            case SPECIFIC_DATA:
                addonDialog.setExtract();
                addonDialog.setSpecificDataType(options.getSpecificDataType());
                break;
            case BY_MASK:
                setExtractByMaskOptions(options);
                break;
        }

        addonDialog.setPlaceResultsToNewColumn(options.isPlaceResultToNewColumn());
        addonDialog.setClearExtractedText(options.isClearExtractedText());
    }


    private void setExtractByMaskOptions(ExtractTextOptions options) {
        addonDialog.setExtractByMask();
        addonDialog.setMask(options.getMask());
        addonDialog.setMaskMatchCase(options.isMaskMatchCase());
    }

    private void setExtractByPositionOptions(ExtractTextOptions options) {
        addonDialog.setExtractByPosition();
        addonDialog.setFirstCharPosition(options.getFirstCharPosition());
        addonDialog.setExtractedCharNumberOption(options.isExtractedCharNumberOption());
        if (options.isExtractedCharNumberOption()) {
            addonDialog.setExtractedCharNumberValue(options.getExtractedCharNumberValue());
        }
    }

    private void setExtractFirstLastCharactersOptions(ExtractTextOptions options) {
        addonDialog.setExtractFirstLastCharacters();
        addonDialog.setCharacterType(options.getCharacterType());
        addonDialog.setCharacterNumber(options.getCharacterNumber());
    }

    private void setExtractByStringsOptions(ExtractTextOptions options) {
        addonDialog.setExtractByStrings();
        addonDialog.setAllAfterTextOption(options.isAllAfterTextOption());
        if (options.isAllAfterTextOption()) {
            addonDialog.setAllAfterTextValue(options.getAllAfterTextValue());
        }
        addonDialog.setAllBeforeTextOption(options.isAllBeforeTextOption());
        if (options.isAllBeforeTextOption()) {
            addonDialog.setAllBeforeTextValue(options.getAllBeforeTextValue());
        }
        addonDialog.setMatchCase(options.isStringMatchCase());
    }


    public void execute() {
        addonDialog.clickExtract();
        waitForProgressMessageDisplayedAndHidden();
    }
}
