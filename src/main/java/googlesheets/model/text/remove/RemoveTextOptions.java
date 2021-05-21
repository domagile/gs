package googlesheets.model.text.remove;

import googlesheets.model.generic.SideAddonOptions;
import googlesheets.model.text.common.enums.CharacterTypeEnumeration;

import java.util.ArrayList;
import java.util.List;

public class RemoveTextOptions implements SideAddonOptions {
    private String range;
    private RemovalTypeEnumeration removalType;
    private SubstringCharacterRemovalSubtypeEnumeration substringCharacterRemovalSubtype;
    private List<String> substrings = new ArrayList<>();
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


    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public RemovalTypeEnumeration getRemovalType() {
        return removalType;
    }

    public void setRemovalType(RemovalTypeEnumeration removalType) {
        this.removalType = removalType;
    }

    public SubstringCharacterRemovalSubtypeEnumeration getSubstringCharacterRemovalSubtype() {
        return substringCharacterRemovalSubtype;
    }

    public void setSubstringCharacterRemovalSubtype(SubstringCharacterRemovalSubtypeEnumeration substringCharacterRemovalSubtype) {
        this.substringCharacterRemovalSubtype = substringCharacterRemovalSubtype;
    }

    public List<String> getSubstrings() {
        return substrings;
    }

    public void setSubstrings(List<String> substrings) {
        this.substrings = substrings;
    }

    public boolean isSubstringMatchCase() {
        return substringMatchCase;
    }

    public void setSubstringMatchCase(boolean substringMatchCase) {
        this.substringMatchCase = substringMatchCase;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    public boolean isRemoveLeadingTrailingSpaces() {
        return removeLeadingTrailingSpaces;
    }

    public void setRemoveLeadingTrailingSpaces(boolean removeLeadingTrailingSpaces) {
        this.removeLeadingTrailingSpaces = removeLeadingTrailingSpaces;
    }

    public boolean isRemoveSpacesBetweenWordsToOne() {
        return removeSpacesBetweenWordsToOne;
    }

    public void setRemoveSpacesBetweenWordsToOne(boolean removeSpacesBetweenWordsToOne) {
        this.removeSpacesBetweenWordsToOne = removeSpacesBetweenWordsToOne;
    }

    public boolean isRemoveAllSpaces() {
        return removeAllSpaces;
    }

    public void setRemoveAllSpaces(boolean removeAllSpaces) {
        this.removeAllSpaces = removeAllSpaces;
    }

    public boolean isRemoveLineBreaks() {
        return removeLineBreaks;
    }

    public void setRemoveLineBreaks(boolean removeLineBreaks) {
        this.removeLineBreaks = removeLineBreaks;
    }

    public boolean isRemoveHtmlEntities() {
        return removeHtmlEntities;
    }

    public void setRemoveHtmlEntities(boolean removeHtmlEntities) {
        this.removeHtmlEntities = removeHtmlEntities;
    }

    public boolean isRemoveHtmlTags() {
        return removeHtmlTags;
    }

    public void setRemoveHtmlTags(boolean removeHtmlTags) {
        this.removeHtmlTags = removeHtmlTags;
    }

    public boolean isRemoveAllDelimiters() {
        return removeAllDelimiters;
    }

    public void setRemoveAllDelimiters(boolean removeAllDelimiters) {
        this.removeAllDelimiters = removeAllDelimiters;
    }

    public boolean isRemoveNonPrintingCharacters() {
        return removeNonPrintingCharacters;
    }

    public void setRemoveNonPrintingCharacters(boolean removeNonPrintingCharacters) {
        this.removeNonPrintingCharacters = removeNonPrintingCharacters;
    }

    public CharacterRemovalByPositionSubtypeEnumeration getCharacterRemovalByPositionSubtype() {
        return characterRemovalByPositionSubtype;
    }

    public void setCharacterRemovalByPositionSubtype(CharacterRemovalByPositionSubtypeEnumeration characterRemovalByPositionSubtype) {
        this.characterRemovalByPositionSubtype = characterRemovalByPositionSubtype;
    }

    public int getFromPosition() {
        return fromPosition;
    }

    public void setFromPosition(int fromPosition) {
        this.fromPosition = fromPosition;
    }

    public int getToPosition() {
        return toPosition;
    }

    public void setToPosition(int toPosition) {
        this.toPosition = toPosition;
    }

    public CharacterTypeEnumeration getCharacterType() {
        return characterType;
    }

    public void setCharacterType(CharacterTypeEnumeration characterType) {
        this.characterType = characterType;
    }

    public int getCharacterNumber() {
        return characterNumber;
    }

    public void setCharacterNumber(int characterNumber) {
        this.characterNumber = characterNumber;
    }

    public TextPositionEnumeration getTextPosition() {
        return textPosition;
    }

    public void setTextPosition(TextPositionEnumeration textPosition) {
        this.textPosition = textPosition;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isTextMatchCase() {
        return textMatchCase;
    }

    public void setTextMatchCase(boolean textMatchCase) {
        this.textMatchCase = textMatchCase;
    }
}
