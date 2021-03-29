package googlesheets.test.rd.removeduplicaterows.generic;

import googlesheets.test.rd.generic.RDTest;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;

public abstract class RDRTest extends RDTest {
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(2);
    }
}


