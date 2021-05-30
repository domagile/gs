package googlesheets.model.text.modify;

public class ModifyTextOptionsBuilder {
    private String range;
    private ModificationTypeEnumeration modificationType;
    private CaseActionEnumeration caseAction;
    private boolean ignoreAbbreviations;
    private boolean ignoreFormulas;
    private ReplacementTypeEnumeration replacementType;
    private boolean removeExtraSpaces;
    private boolean addSpaceAfterPunctuationMarks;
    private boolean sentenceCase;

    public ModifyTextOptionsBuilder setRange(String range) {
        this.range = range;
        return this;
    }

    public ModifyTextOptionsBuilder setModificationType(ModificationTypeEnumeration modificationType) {
        this.modificationType = modificationType;
        return this;
    }

    public ModifyTextOptionsBuilder setCaseAction(CaseActionEnumeration caseAction) {
        this.caseAction = caseAction;
        return this;
    }

    public ModifyTextOptionsBuilder setIgnoreAbbreviations(boolean ignoreAbbreviations) {
        this.ignoreAbbreviations = ignoreAbbreviations;
        return this;
    }

    public ModifyTextOptionsBuilder setIgnoreFormulas(boolean ignoreFormulas) {
        this.ignoreFormulas = ignoreFormulas;
        return this;
    }

    public ModifyTextOptionsBuilder setReplacementType(ReplacementTypeEnumeration replacementType) {
        this.replacementType = replacementType;
        return this;
    }

    public ModifyTextOptionsBuilder setRemoveExtraSpaces(boolean removeExtraSpaces) {
        this.removeExtraSpaces = removeExtraSpaces;
        return this;
    }

    public ModifyTextOptionsBuilder setAddSpaceAfterPunctuationMarks(boolean addSpaceAfterPunctuationMarks) {
        this.addSpaceAfterPunctuationMarks = addSpaceAfterPunctuationMarks;
        return this;
    }

    public ModifyTextOptionsBuilder setSentenceCase(boolean sentenceCase) {
        this.sentenceCase = sentenceCase;
        return this;
    }

    public ModifyTextOptions build() {
        ModifyTextOptions options = new ModifyTextOptions();
        options.setRange(range);
        options.setModificationType(modificationType);
        options.setCaseAction(caseAction);
        options.setIgnoreAbbreviations(ignoreAbbreviations);
        options.setIgnoreFormulas(ignoreFormulas);
        options.setReplacementType(replacementType);
        options.setRemoveExtraSpaces(removeExtraSpaces);
        options.setAddSpaceAfterPunctuationMarks(addSpaceAfterPunctuationMarks);
        options.setSentenceCase(sentenceCase);
        return options;
    }
}