package googlesheets.model.advancedfindreplace;

import googlesheets.service.advancedfindreplace.SearchInSelection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdvancedFindReplaceOptionBuilder {
    private String searchString;
    private boolean matchCase;
    private boolean entireCell;
    private boolean byMask;
    private boolean values;
    private boolean formulas;
    private boolean notes;
    private boolean hyperlinks;
    private boolean errors;
    private SearchInSelection searchInType = SearchInSelection.SELECTED_LISTS;
    private List<Integer> searchSheetIndexes = new ArrayList<>();
    private String selectedRange;

    public AdvancedFindReplaceOptionBuilder matchCase(boolean matchCase) {
        this.matchCase = matchCase;
        return this;
    }

    public AdvancedFindReplaceOptionBuilder entireCell(boolean entireCell) {
        this.entireCell = entireCell;
        return this;
    }

    public AdvancedFindReplaceOptionBuilder byMask(boolean byMask) {
        this.byMask = byMask;
        return this;
    }

    public AdvancedFindReplaceOptionBuilder values(boolean value) {
        this.values = value;
        return this;
    }

    public AdvancedFindReplaceOptionBuilder formulas(boolean formulas) {
        this.formulas = formulas;
        return this;
    }

    public AdvancedFindReplaceOptionBuilder notes(boolean notes) {
        this.notes = notes;
        return this;
    }

    public AdvancedFindReplaceOptionBuilder hyperlinks(boolean hyperlinks) {
        this.hyperlinks = hyperlinks;
        return this;
    }

    public AdvancedFindReplaceOptionBuilder errors(boolean errors) {
        this.errors = errors;
        return this;
    }

    public AdvancedFindReplaceOptionBuilder selectedRange(String selectedRange) {
        this.selectedRange = selectedRange;
        return this;
    }


    public AdvancedFindReplaceOptionBuilder searchString(String searchString) {
        this.searchString = searchString;
        return this;
    }


    public AdvancedFindReplaceOptionBuilder searchInType(SearchInSelection searchInType) {
        this.searchInType = searchInType;
        return this;
    }


    public AdvancedFindReplaceOptionBuilder searchSheetIndexes(Integer... indexes) {
        searchSheetIndexes = Arrays.asList(indexes);
        return this;
    }


    public AdvancedFindReplaceOptions build() {
        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptions();
        options.setMatchCase(matchCase);
        options.setEntireCell(entireCell);
        options.setByMask(byMask);
        options.setValue(values);
        options.setFormulas(formulas);
        options.setNotes(notes);
        options.setHyperlinks(hyperlinks);
        options.setErrors(errors);
        options.setRange(selectedRange);
        options.setSearchSheetIndexes(searchSheetIndexes);
        options.setSearchString(searchString);
        return options;
    }
}
