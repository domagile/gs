package googlesheets.model.text.remove;

import googlesheets.model.text.common.enums.CharacterTypeEnumeration;

import java.util.Arrays;
import java.util.List;

public class RemoveTextOptionsBuilder {
    private String range;
    private RemovalTypeEnumeration removalType;
    private SubstringCharacterRemovalSubtypeEnumeration substringCharacterRemovalSubtype;
    private List<String> substrings;
    private boolean substringMatchCase;
    private String characters;
    private boolean removeLeadingTrailingSpaces;
    private boolean removeSpacesBetweenWordsToOne;
    private boolean removeAllSpaces;
    private boolean removeLineBreaks;
    private boolean removeHtmlEntities;
    private boolean removeHtmlTags;
    private boolean removeAllDelimiters;
    private boolean removeNonPrintingCharacters;
    private CharacterRemovalByPositionSubtypeEnumeration characterRemovalByPositionSubtype;
    private int fromPosition;
    private int toPosition;
    private CharacterTypeEnumeration characterType;
    private int characterNumber;
    private TextPositionEnumeration textPosition;
    private String text;
    private boolean textMatchCase;

    public RemoveTextOptionsBuilder range(String range) {
        this.range = range;
        return this;
    }

    public RemoveTextOptionsBuilder removalType(RemovalTypeEnumeration removalType) {
        this.removalType = removalType;
        return this;
    }

    public RemoveTextOptionsBuilder substringCharacterRemovalSubtype(SubstringCharacterRemovalSubtypeEnumeration substringCharacterRemovalSubtype) {
        this.substringCharacterRemovalSubtype = substringCharacterRemovalSubtype;
        return this;
    }

    public RemoveTextOptionsBuilder substrings(String... substrings) {
        this.substrings = Arrays.asList(substrings);
        return this;
    }

    public RemoveTextOptionsBuilder substringMatchCase(boolean substringMatchCase) {
        this.substringMatchCase = substringMatchCase;
        return this;
    }

    public RemoveTextOptionsBuilder characters(String characters) {
        this.characters = characters;
        return this;
    }

    public RemoveTextOptionsBuilder removeLeadingTrailingSpaces(boolean removeLeadingTrailingSpaces) {
        this.removeLeadingTrailingSpaces = removeLeadingTrailingSpaces;
        return this;
    }

    public RemoveTextOptionsBuilder removeSpacesBetweenWordsToOne(boolean removeSpacesBetweenWordsToOne) {
        this.removeSpacesBetweenWordsToOne = removeSpacesBetweenWordsToOne;
        return this;
    }

    public RemoveTextOptionsBuilder removeAllSpaces(boolean removeAllSpaces) {
        this.removeAllSpaces = removeAllSpaces;
        return this;
    }

    public RemoveTextOptionsBuilder removeLineBreaks(boolean removeLineBreaks) {
        this.removeLineBreaks = removeLineBreaks;
        return this;
    }

    public RemoveTextOptionsBuilder removeHtmlEntities(boolean removeHtmlEntities) {
        this.removeHtmlEntities = removeHtmlEntities;
        return this;
    }

    public RemoveTextOptionsBuilder removeHtmlTags(boolean removeHtmlTags) {
        this.removeHtmlTags = removeHtmlTags;
        return this;
    }

    public RemoveTextOptionsBuilder removeAllDelimiters(boolean removeAllDelimiters) {
        this.removeAllDelimiters = removeAllDelimiters;
        return this;
    }

    public RemoveTextOptionsBuilder removeNonPrintingCharacters(boolean removeNonPrintingCharacters) {
        this.removeNonPrintingCharacters = removeNonPrintingCharacters;
        return this;
    }

    public RemoveTextOptionsBuilder characterRemovalByPositionSubtype(CharacterRemovalByPositionSubtypeEnumeration characterRemovalByPositionSubtype) {
        this.characterRemovalByPositionSubtype = characterRemovalByPositionSubtype;
        return this;
    }

    public RemoveTextOptionsBuilder fromPosition(int fromPosition) {
        this.fromPosition = fromPosition;
        return this;
    }

    public RemoveTextOptionsBuilder toPosition(int toPosition) {
        this.toPosition = toPosition;
        return this;
    }

    public RemoveTextOptionsBuilder characterType(CharacterTypeEnumeration characterType) {
        this.characterType = characterType;
        return this;
    }

    public RemoveTextOptionsBuilder characterNumber(int characterNumber) {
        this.characterNumber = characterNumber;
        return this;
    }

    public RemoveTextOptionsBuilder textPosition(TextPositionEnumeration textPosition) {
        this.textPosition = textPosition;
        return this;
    }

    public RemoveTextOptionsBuilder text(String text) {
        this.text = text;
        return this;
    }

    public RemoveTextOptionsBuilder textMatchCase(boolean textMatchCase) {
        this.textMatchCase = textMatchCase;
        return this;
    }

    public RemoveTextOptions build() {
        RemoveTextOptions options = new RemoveTextOptions();
        options.setRange(range);
        options.setRemovalType(removalType);
        options.setSubstringCharacterRemovalSubtype(substringCharacterRemovalSubtype);
        options.setSubstrings(substrings);
        options.setSubstringMatchCase(substringMatchCase);
        options.setCharacters(characters);
        options.setRemoveLeadingTrailingSpaces(removeLeadingTrailingSpaces);
        options.setRemoveSpacesBetweenWordsToOne(removeSpacesBetweenWordsToOne);
        options.setRemoveAllSpaces(removeAllSpaces);
        options.setRemoveLineBreaks(removeLineBreaks);
        options.setRemoveHtmlEntities(removeHtmlEntities);
        options.setRemoveHtmlTags(removeHtmlTags);
        options.setRemoveAllDelimiters(removeAllDelimiters);
        options.setRemoveNonPrintingCharacters(removeNonPrintingCharacters);
        options.setCharacterRemovalByPositionSubtype(characterRemovalByPositionSubtype);
        options.setFromPosition(fromPosition);
        options.setToPosition(toPosition);
        options.setCharacterType(characterType);
        options.setCharacterNumber(characterNumber);
        options.setTextPosition(textPosition);
        options.setText(text);
        options.setTextMatchCase(textMatchCase);
        return options;
    }
}