package googlesheets.model.text.split;

import java.util.Arrays;
import java.util.List;

public class SplitTextOptionsBuilder {
    private String range;
    private SplitTypeEnumeration splitType = SplitTypeEnumeration.BY_CHARACTER;
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

    public SplitTextOptionsBuilder range(String range) {
        this.range = range;
        return this;
    }

    public SplitTextOptionsBuilder splitType(SplitTypeEnumeration splitType) {
        this.splitType = splitType;
        return this;
    }

    public SplitTextOptionsBuilder splitValuesType(SplitValuesTypeEnumeration splitValuesType) {
        this.splitValuesType = splitValuesType;
        return this;
    }

    public SplitTextOptionsBuilder space(boolean space) {
        this.space = space;
        return this;
    }

    public SplitTextOptionsBuilder lineBreak(boolean lineBreak) {
        this.lineBreak = lineBreak;
        return this;
    }

    public SplitTextOptionsBuilder comma(boolean comma) {
        this.comma = comma;
        return this;
    }

    public SplitTextOptionsBuilder semicolon(boolean semicolon) {
        this.semicolon = semicolon;
        return this;
    }

    public SplitTextOptionsBuilder customOption(boolean customOption) {
        this.customOption = customOption;
        return this;
    }

    public SplitTextOptionsBuilder customCharacters(String customCharacters) {
        this.customCharacters = customCharacters;
        return this;
    }

    public SplitTextOptionsBuilder strings(String... strings) {
        this.strings = Arrays.asList(strings);
        return this;
    }

    public SplitTextOptionsBuilder matchCase(boolean matchCase) {
        this.matchCase = matchCase;
        return this;
    }

    public SplitTextOptionsBuilder treatConsecutiveDelimitersAsOne(boolean treatConsecutiveDelimitersAsOne) {
        this.treatConsecutiveDelimitersAsOne = treatConsecutiveDelimitersAsOne;
        return this;
    }

    public SplitTextOptionsBuilder replaceSourceData(boolean replaceSourceData) {
        this.replaceSourceData = replaceSourceData;
        return this;
    }

    public SplitTextOptions build() {
        SplitTextOptions options = new SplitTextOptions();
        options.setRange(range);
        options.setSplitType(splitType);
        options.setSplitValuesType(splitValuesType);
        options.setSpace(space);
        options.setLineBreak(lineBreak);
        options.setComma(comma);
        options.setSemicolon(semicolon);
        options.setCustomOption(customOption);
        options.setCustomCharacters(customCharacters);
        options.setStrings(strings);
        options.setMatchCase(matchCase);
        options.setTreatConsecutiveDelimitersAsOne(treatConsecutiveDelimitersAsOne);
        options.setReplaceSourceData(replaceSourceData);
        return options;
    }
}