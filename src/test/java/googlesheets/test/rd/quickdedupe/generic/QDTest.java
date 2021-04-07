package googlesheets.test.rd.quickdedupe.generic;


import googlesheets.model.rd.quickdedupe.QuickDedupeOptions;
import googlesheets.service.generic.addon.GenericAddonService;
import googlesheets.test.rd.generic.RDTest;

import static googlesheets.service.generic.google.GoogleSheetService.sleep;
import static googlesheets.service.removeduplicates.quickdedupe.QuickDedupeService.*;

public class QDTest extends RDTest {
    public void execute(QuickDedupeOptions options)
    {
        runQuickDedupe();
        if (options.getRange() != null) {
            GenericAddonService.setNameBoxValueFromAddonContext(options.getRange());
            sleep(2000);
        }
        setTableHasHeaders(options.isTableHasHeaders());
        setSkipEmptyCells(options.isSkipEmptyCells());
        setCreateBackupCopyOfSheet(options.isCreateSheetBackupCopy());

        selectColumnsToSearchIn(options.getColumnIndexes());
        selectAction(options.getAction());

        clickFinishAndClose();

    }
}
