package googlesheets.service.text.extract;

import googlesheets.model.text.extract.ExtractTextOptions;
import googlesheets.service.generic.addon.SideAddonService;
import googlesheets.ui.text.extract.ExtractTextDialog;

import static googlesheets.service.generic.addon.GenericAddonService.*;

public class ExtractTextService implements SideAddonService<ExtractTextOptions> {
    private final ExtractTextDialog addonDialog = new ExtractTextDialog();

    public void runAddon()
    {
        new ExtractTextRunner().runAddon();
    }

    public void selectRange(String range) {
        setNameBoxValue(range);
    }

    public void setOptions(ExtractTextOptions options) {
        addonDialog.setExtractType(options.getExtractType());
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
                setExtractNumbersOptions(options);
                break;
            case LINKS:
                setExtractLinksOptions(options);
                break;
            case BY_MASK:
                setExtractByMaskOptions(options);
                break;
        }
    }

    private void setExtractLinksOptions(ExtractTextOptions options) {
        addonDialog.setSpecificDataType(options.getSpecificDataType());
        addonDialog.setExtractAllOccurrencesLinks(options.isExtractAllOccurrences());
        if (options.isExtractAllOccurrences()) {
            addonDialog.setAllOccurrencesPlacementLinks(options.getAllOccurrencesPlacement());
        }
        addonDialog.setInsertNewColumnWithResultsLinks(options.isInsertNewColumnWithResult());
        addonDialog.setClearExtractedTextLinks(options.isClearExtractedText());
    }


    private void setExtractNumbersOptions(ExtractTextOptions options) {
        addonDialog.setNumbersHaveSeparators(options.isNumbersHaveSeparators());
        if (options.isNumbersHaveSeparators()) {
            addonDialog.setDecimalSeparator(options.getDecimalSeparator());
            addonDialog.setThousandsSeparator(options.getThousandsSeparator());
        }
        addonDialog.setExtractAllOccurrencesNumbers(options.isExtractAllOccurrences());
        if (options.isExtractAllOccurrences()) {
            addonDialog.setAllOccurrencesPlacementNumbers(options.getAllOccurrencesPlacement());
        }
        addonDialog.setInsertNewColumnWithResultsNumbers(options.isInsertNewColumnWithResult());
        addonDialog.setClearExtractedTextNumbers(options.isClearExtractedText());
    }


    private void setExtractByMaskOptions(ExtractTextOptions options) {
        addonDialog.setMask(options.getMask());
        addonDialog.setMatchCaseByMask(options.isMatchCase());
        addonDialog.setExtractAllOccurrencesByMask(options.isExtractAllOccurrences());
        if (options.isExtractAllOccurrences()) {
            addonDialog.setAllOccurrencesPlacementByMask(options.getAllOccurrencesPlacement());
        }
        addonDialog.setInsertNewColumnWithResultsByMask(options.isInsertNewColumnWithResult());
        addonDialog.setClearExtractedTextByMask(options.isClearExtractedText());
    }

    private void setExtractByPositionOptions(ExtractTextOptions options) {
        addonDialog.setFirstCharPosition(options.getFirstCharPosition());
        addonDialog.setExtractedCharNumberOption(options.isExtractedCharNumberOption());
        if (options.isExtractedCharNumberOption()) {
            addonDialog.setExtractedCharNumberValue(options.getExtractedCharNumberValue());
        }
        addonDialog.setInsertNewColumnWithResultsByPosition(options.isInsertNewColumnWithResult());
        addonDialog.setClearExtractedTextByPosition(options.isClearExtractedText());
    }

    private void setExtractFirstLastCharactersOptions(ExtractTextOptions options) {
        addonDialog.setCharacterType(options.getCharacterType());
        addonDialog.setCharacterNumber(options.getCharacterNumber());
        addonDialog.setInsertNewColumnWithResultsFirstLastCharacters(options.isInsertNewColumnWithResult());
        addonDialog.setClearExtractedTextFirstLastCharacters(options.isClearExtractedText());
    }

    private void setExtractByStringsOptions(ExtractTextOptions options) {
        addonDialog.setAllAfterTextOption(options.isAllAfterTextOption());
        if (options.isAllAfterTextOption()) {
            addonDialog.setAllAfterTextValue(options.getAllAfterTextValue());
        }
        addonDialog.setAllBeforeTextOption(options.isAllBeforeTextOption());
        if (options.isAllBeforeTextOption()) {
            addonDialog.setAllBeforeTextValue(options.getAllBeforeTextValue());
        }
        addonDialog.setMatchCaseByStrings(options.isMatchCase());
        addonDialog.setExtractAllOccurrencesByStrings(options.isExtractAllOccurrences());
        if (options.isExtractAllOccurrences()) {
            addonDialog.setAllOccurrencesPlacementByStrings(options.getAllOccurrencesPlacement());
        }
        addonDialog.setInsertNewColumnWithResultsByStrings(options.isInsertNewColumnWithResult());
        addonDialog.setClearExtractedTextByStrings(options.isClearExtractedText());
    }


    public void execute() {
        addonDialog.clickExtract();
        waitForProgressMessageDisplayedAndHidden();
    }
}
