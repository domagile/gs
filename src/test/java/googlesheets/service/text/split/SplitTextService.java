package googlesheets.service.text.split;

import googlesheets.model.text.split.SplitTextOptions;
import googlesheets.service.generic.addon.SideAddonService;
import googlesheets.ui.text.split.SplitTextDialog;

import static googlesheets.service.generic.addon.GenericAddonService.setNameBoxValue;
import static googlesheets.service.generic.addon.GenericAddonService.waitForWorkingMessageDisplayedAndHidden;

public class SplitTextService implements SideAddonService<SplitTextOptions> {
    private SplitTextDialog addonDialog = new SplitTextDialog();

    @Override
    public void selectRange(String range) {
        setNameBoxValue(range);
    }


    @Override
    public void runAddon() {
        new SplitTextRunner().runAddon();
    }

    @Override
    public void setOptions(SplitTextOptions options) {
        addonDialog.setSplitType(options.getSplitType());
        switch (options.getSplitType()) {
            case BY_CHARACTER:
                setByCharacterOptions(options);
                break;
            case BY_POSITION:
                break;
        }
    }

    private void setByCharacterOptions(SplitTextOptions options) {
        switch (options.getSplitValuesType()) {
            case BY_CHARACTERS:
                setSplitValuesByCharactersOptions(options);
                break;
            case BY_STRINGS:
                setSplitValuesByStringsOptions(options);
                break;
            case BY_CAPITAL_LETTER:
                addonDialog.setSplitValuesByCapitalLetter();
                break;
        }
        addonDialog.setTreatConsecutiveDelimitersAsOne(options.isTreatConsecutiveDelimitersAsOne());
        addonDialog.setReplaceSourceData(options.isReplaceSourceData());
    }

    private void setSplitValuesByStringsOptions(SplitTextOptions options) {
        addonDialog.setSplitValuesByStrings();
        addonDialog.setStrings(options.getStrings());
        addonDialog.setMatchCase(options.isMatchCase());
    }

    private void setSplitValuesByCharactersOptions(SplitTextOptions options) {
        addonDialog.setSplitValuesByCharacters();
        addonDialog.setSpace(options.isSpace());
        addonDialog.setLineBreak(options.isLineBreak());
        addonDialog.setComma(options.isComma());
        addonDialog.setSemicolon(options.isSemicolon());
        addonDialog.setCustomOption(options.isCustomOption());
        if (options.isCustomOption()) {
            addonDialog.setCustomCharacters(options.getCustomCharacters());
        }
    }

    @Override
    public void execute() {
        addonDialog.clickSplitButton();
        waitForWorkingMessageDisplayedAndHidden();
    }
}
