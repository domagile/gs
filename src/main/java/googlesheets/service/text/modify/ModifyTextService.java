package googlesheets.service.text.modify;

import googlesheets.model.text.modify.ModifyTextOptions;
import googlesheets.service.generic.addon.SideAddonService;
import googlesheets.ui.text.modify.ModifyTextDialog;

import static googlesheets.service.generic.addon.GenericAddonService.setNameBoxValue;
import static googlesheets.service.generic.addon.GenericAddonService.waitForWorkingMessageDisplayedAndHidden;

public class ModifyTextService implements SideAddonService<ModifyTextOptions> {
    private ModifyTextDialog addonDialog = new ModifyTextDialog();

    @Override
    public void selectRange(String range) {
        setNameBoxValue(range);
    }


    @Override
    public void runAddon() {
        new ModifyTextRunner().runAddon();
    }

    @Override
    public void setOptions(ModifyTextOptions options) {
        addonDialog.setModificationType(options.getModificationType());
        switch (options.getModificationType()) {
            case CHANGE_CASE:
                setChangeCaseOptions(options);
                break;
            case REPLACE_SYMBOLS:
                setReplaceSymbolsOptions(options);
                break;
            case POLISH_TEXT:
                setPolishTextOptions(options);
                break;
        }
    }

    private void setChangeCaseOptions(ModifyTextOptions options) {
        switch (options.getCaseAction()) {
            case SENTENCE_CASE:
                addonDialog.setSentenceCaseRadioButton();
                break;
            case CAPITALIZE_EACH_WORD:
                addonDialog.setCapitalizeEachWord();
                addonDialog.setIgnoreAbbreviations(options.isIgnoreAbbreviations());
                break;
            case LOWER_CASE:
                addonDialog.setLowerCase();
                break;
            case UPPER_CASE:
                addonDialog.setUpperCase();
                break;
            case TOGGLE_TEXT:
                addonDialog.setToggleText();
                break;
        }
        addonDialog.setIgnoreFormulas(options.isIgnoreFormulas());
    }

    private void setReplaceSymbolsOptions(ModifyTextOptions options) {
        switch (options.getReplacementType()) {
            case ACCENTED_CHARACTERS:
                addonDialog.setReplaceAccentedCharacters();
                break;
            case CODES_WITH_SYMBOLS:
                addonDialog.setReplaceCodesWithSymbols();
                break;
            case SYMBOLS_WITH_CODES:
                addonDialog.setReplaceSymbolsWithCodes();
                break;
            case SMART_QUOTES_WITH_STRAIGHT_QUOTES:
                addonDialog.setReplaceSmartQuotesWithStraightQuotes();
                break;
        }
    }

    private void setPolishTextOptions(ModifyTextOptions options) {
        addonDialog.setRemoveExtraSpaces(options.isRemoveExtraSpaces());
        addonDialog.setAddSpaceAfterPunctuationMarks(options.isAddSpaceAfterPunctuationMarks());
        addonDialog.setSentenceCaseCheckBox(options.isSentenceCase());
    }

    @Override
    public void execute() {
        addonDialog.clickRunButton();
        waitForWorkingMessageDisplayedAndHidden();
    }
}

