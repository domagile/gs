package googlesheets.service.process.multiplevlookupmatches;

import googlesheets.model.process.multiplevlookupmatches.MultipleVlookupMatchesOptions;
import googlesheets.ui.process.multiplevlookupmatches.MultipleVlookupMatchesDialog;

public class MultipleVlookupMatchesService {
    private MultipleVlookupMatchesDialog dialog = new MultipleVlookupMatchesDialog();

    public void runAddon() {
        new MultipleVlookupMatchesRunner().runAddon();
    }


    public void setOptions(MultipleVlookupMatchesOptions options) {
        dialog.setSourceRange(options.getSourceRange());
        dialog.setTableHasHeader(options.isTableHasHeader());
        dialog.setRowReturnType(options.getRowReturnType());
        dialog.setRowNumber(options.getRowNumber());
    }


    public void execute() {
    }
}