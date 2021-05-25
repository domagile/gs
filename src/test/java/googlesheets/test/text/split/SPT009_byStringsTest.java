package googlesheets.test.text.split;

import googlesheets.model.text.split.SplitTextOptions;
import googlesheets.model.text.split.SplitTextOptionsBuilder;
import googlesheets.model.text.split.SplitValuesTypeEnumeration;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;

public class SPT009_byStringsTest extends SPTTest {
    @Test
    public void split() {
        SplitTextOptions options = new SplitTextOptionsBuilder()
                .range("A1:A9")
                .splitValuesType(SplitValuesTypeEnumeration.BY_STRINGS)
                .strings("or", "and", "not", "OR", "AND", "NOT")
                .build();
        execute(options);
        checkResult();
    }


    @Override
    protected void restoreInitialDocumentState() {
        clickUndo(2);
    }
}
