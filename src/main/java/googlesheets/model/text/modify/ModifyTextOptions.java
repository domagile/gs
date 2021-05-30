package googlesheets.model.text.modify;

import googlesheets.model.generic.SideAddonOptions;

public class ModifyTextOptions implements SideAddonOptions {
    private String range;
    private ModificationTypeEnumeration modificationType;
    private CaseActionEnumeration caseAction;
    private boolean ignoreAbbreviations;
    private boolean ignoreFormulas;
    private ReplacementTypeEnumeration replacementType;
    private boolean removeExtraSpaces;
    private boolean addSpaceAfterPunctuationMarks;
    private boolean sentenceCase;


    @Override
    public String getRange() {
        return range;
    }

    @Override
    public void setRange(String range) {
        this.range = range;
    }

    public ModificationTypeEnumeration getModificationType() {
        return modificationType;
    }

    public void setModificationType(ModificationTypeEnumeration modificationType) {
        this.modificationType = modificationType;
    }

    public CaseActionEnumeration getCaseAction() {
        return caseAction;
    }

    public void setCaseAction(CaseActionEnumeration caseAction) {
        this.caseAction = caseAction;
    }

    public boolean isIgnoreAbbreviations() {
        return ignoreAbbreviations;
    }

    public void setIgnoreAbbreviations(boolean ignoreAbbreviations) {
        this.ignoreAbbreviations = ignoreAbbreviations;
    }

    public boolean isIgnoreFormulas() {
        return ignoreFormulas;
    }

    public void setIgnoreFormulas(boolean ignoreFormulas) {
        this.ignoreFormulas = ignoreFormulas;
    }

    public ReplacementTypeEnumeration getReplacementType() {
        return replacementType;
    }

    public void setReplacementType(ReplacementTypeEnumeration replacementType) {
        this.replacementType = replacementType;
    }

    public boolean isRemoveExtraSpaces() {
        return removeExtraSpaces;
    }

    public void setRemoveExtraSpaces(boolean removeExtraSpaces) {
        this.removeExtraSpaces = removeExtraSpaces;
    }

    public boolean isAddSpaceAfterPunctuationMarks() {
        return addSpaceAfterPunctuationMarks;
    }

    public void setAddSpaceAfterPunctuationMarks(boolean addSpaceAfterPunctuationMarks) {
        this.addSpaceAfterPunctuationMarks = addSpaceAfterPunctuationMarks;
    }

    public boolean isSentenceCase() {
        return sentenceCase;
    }

    public void setSentenceCase(boolean sentenceCase) {
        this.sentenceCase = sentenceCase;
    }
}
