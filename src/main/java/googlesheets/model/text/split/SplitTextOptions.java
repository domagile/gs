package googlesheets.model.text.split;

import googlesheets.model.generic.SideAddonOptions;

import java.util.List;

public class SplitTextOptions implements SideAddonOptions {
    private String range;
    private SplitTypeEnumeration splitType;
    private SplitValuesTypeEnumeration splitValuesType;
    private boolean space;
    private boolean lineBreak;
    private boolean comma;
    private boolean semicolon;
    private boolean customOption;
    private String customCharacters;
    private List<String> strings;
    private boolean matchCase;
    private boolean treatConsecutiveDelimitersAsOne;
    private boolean replaceSourceData;


    @Override
    public String getRange() {
        return range;
    }

    @Override
    public void setRange(String range) {
        this.range = range;
    }

    public SplitTypeEnumeration getSplitType() {
        return splitType;
    }

    public void setSplitType(SplitTypeEnumeration splitType) {
        this.splitType = splitType;
    }

    public SplitValuesTypeEnumeration getSplitValuesType() {
        return splitValuesType;
    }

    public void setSplitValuesType(SplitValuesTypeEnumeration splitValuesType) {
        this.splitValuesType = splitValuesType;
    }

    public boolean isSpace() {
        return space;
    }

    public void setSpace(boolean space) {
        this.space = space;
    }

    public boolean isLineBreak() {
        return lineBreak;
    }

    public void setLineBreak(boolean lineBreak) {
        this.lineBreak = lineBreak;
    }

    public boolean isComma() {
        return comma;
    }

    public void setComma(boolean comma) {
        this.comma = comma;
    }

    public boolean isSemicolon() {
        return semicolon;
    }

    public void setSemicolon(boolean semicolon) {
        this.semicolon = semicolon;
    }

    public boolean isCustomOption() {
        return customOption;
    }

    public void setCustomOption(boolean customOption) {
        this.customOption = customOption;
    }

    public String getCustomCharacters() {
        return customCharacters;
    }

    public void setCustomCharacters(String customCharacters) {
        this.customCharacters = customCharacters;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    public boolean isMatchCase() {
        return matchCase;
    }

    public void setMatchCase(boolean matchCase) {
        this.matchCase = matchCase;
    }

    public boolean isTreatConsecutiveDelimitersAsOne() {
        return treatConsecutiveDelimitersAsOne;
    }

    public void setTreatConsecutiveDelimitersAsOne(boolean treatConsecutiveDelimitersAsOne) {
        this.treatConsecutiveDelimitersAsOne = treatConsecutiveDelimitersAsOne;
    }

    public boolean isReplaceSourceData() {
        return replaceSourceData;
    }

    public void setReplaceSourceData(boolean replaceSourceData) {
        this.replaceSourceData = replaceSourceData;
    }
}
