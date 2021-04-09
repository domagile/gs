package googlesheets.model.advancedfindreplace;

import googlesheets.model.rd.quickdedupe.QuickDedupeActionEnumeration;
import googlesheets.service.advancedfindreplace.SearchInSelection;

import java.util.ArrayList;
import java.util.List;

public class AdvancedFindReplaceOptions {
    private String searchString;
    private boolean matchCase;
    private boolean entireCell;
    private boolean byMask;
    private boolean value;
    private boolean formulas;
    private boolean notes;
    private boolean hyperlinks;
    private boolean errors;
    private SearchInSelection searchInType = SearchInSelection.SELECTED_LISTS;
    private List<Integer> searchSheetIndexes = new ArrayList<>();
    private String selectedRange;

    public boolean isMatchCase() {
        return matchCase;
    }

    public void setMatchCase(boolean matchCase) {
        this.matchCase = matchCase;
    }

    public boolean isEntireCell() {
        return entireCell;
    }

    public void setEntireCell(boolean entireCell) {
        this.entireCell = entireCell;
    }

    public boolean isByMask() {
        return byMask;
    }

    public void setByMask(boolean byMask) {
        this.byMask = byMask;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public boolean isFormulas() {
        return formulas;
    }

    public void setFormulas(boolean formulas) {
        this.formulas = formulas;
    }

    public boolean isNotes() {
        return notes;
    }

    public void setNotes(boolean notes) {
        this.notes = notes;
    }

    public boolean isHyperlinks() {
        return hyperlinks;
    }

    public void setHyperlinks(boolean hyperlinks) {
        this.hyperlinks = hyperlinks;
    }

    public boolean isErrors() {
        return errors;
    }

    public void setErrors(boolean errors) {
        this.errors = errors;
    }

    public String getSelectedRange() {
        return selectedRange;
    }

    public void setSelectedRange(String selectedRange) {
        this.selectedRange = selectedRange;
    }

    public void setRange(String range) {
        this.selectedRange = selectedRange;
    }

    public SearchInSelection getSearchInType() {
        return searchInType;
    }

    public void setSearchInType(SearchInSelection searchInType) {
        this.searchInType = searchInType;
    }

    public List<Integer> getSearchSheetIndexes() {
        return searchSheetIndexes;
    }

    public void setSearchSheetIndexes(List<Integer> searchSheetIndexes) {
        this.searchSheetIndexes = searchSheetIndexes;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}
