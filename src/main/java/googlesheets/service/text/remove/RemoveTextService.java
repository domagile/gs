package googlesheets.service.text.remove;

import googlesheets.model.text.remove.RemoveTextOptions;
import googlesheets.service.generic.addon.SideAddonService;
import googlesheets.ui.text.remove.RemoveTextDialog;

import static googlesheets.service.generic.addon.GenericAddonService.setNameBoxValue;
import static googlesheets.service.generic.addon.GenericAddonService.waitForWorkingMessageDisplayedAndHidden;

public class RemoveTextService implements SideAddonService<RemoveTextOptions> {
    private RemoveTextDialog addonDialog = new RemoveTextDialog();

    @Override
    public void selectRange(String range) {
        setNameBoxValue(range);
    }


    @Override
    public void runAddon() {
        new RemoveTextRunner().runAddon();
    }

    @Override
    public void setOptions(RemoveTextOptions options) {
        addonDialog.setRemovalType(options.getRemovalType());
        switch (options.getRemovalType()) {
            case SUBSTRINGS_OR_CHARACTERS:
                setSubstringsCharactersOptions(options);
                break;
            case SPACES_AND_DELIMITERS:
                setSpacesDelimitersOptions(options);
                break;
            case CHARACTERS_BY_POSITION:
                setCharactersByPositionOptions(options);
                break;
        }
    }

    private void setCharactersByPositionOptions(RemoveTextOptions options) {
        switch (options.getCharacterRemovalByPositionSubtype()) {
            case CHARACTERS_BY_POSITION:
                addonDialog.setRemoveCharactersByPosition();
                addonDialog.setFromPosition(options.getFromPosition());
                addonDialog.setToPosition(options.getToPosition());
                break;
            case FIRST_LAST_CHARACTERS:
                addonDialog.setRemoveFirstLastCharacters();
                addonDialog.setCharacterType(options.getCharacterType());
                addonDialog.setCharacterNumber(options.getCharacterNumber());
                break;
            case CHARACTERS_BEFORE_AFTER_TEXT:
                addonDialog.setRemoveCharactersBeforeAfterText();
                addonDialog.setTextPosition(options.getTextPosition());
                addonDialog.setBeforeAfterText(options.getText());
                addonDialog.setTextMatchCase(options.isTextMatchCase());
                break;
        }
    }

    private void setSubstringsCharactersOptions(RemoveTextOptions options) {
        switch (options.getSubstringCharacterRemovalSubtype()) {
            case SUBSTRINGS:
                addonDialog.setRemoveSubstrings();
                addonDialog.setSubstrings(options.getSubstrings());
                addonDialog.setSubstringsMatchCase(options.isSubstringMatchCase());
                break;
            case CHARACTERS:
                addonDialog.setRemoveCharacters();
                addonDialog.setCharacters(options.getCharacters());
                break;
        }
    }

    private void setSpacesDelimitersOptions(RemoveTextOptions options) {
        addonDialog.setRemoveLeadingTrailingSpaces(options.isRemoveLeadingTrailingSpaces());
        addonDialog.setRemoveSpacesBetweenWordsToOne(options.isRemoveSpacesBetweenWordsToOne());
        addonDialog.setRemoveAllSpaces(options.isRemoveAllSpaces());
        addonDialog.setRemoveLineBreaks(options.isRemoveLineBreaks());
        addonDialog.setRemoveHtmlEntities(options.isRemoveHtmlEntities());
        addonDialog.setRemoveHtmlTags(options.isRemoveHtmlTags());
        addonDialog.setRemoveAllDelimiters(options.isRemoveAllDelimiters());
        addonDialog.setRemoveNonPrintingCharacters(options.isRemoveNonPrintingCharacters());
    }

    @Override
    public void execute() {
        addonDialog.clickRemoveButton();
        waitForWorkingMessageDisplayedAndHidden();
    }
}
