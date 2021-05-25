package googlesheets.test.text.split;

import googlesheets.model.text.split.SplitTextOptions;
import googlesheets.model.text.split.SplitTextOptionsBuilder;
import googlesheets.model.text.split.SplitValuesTypeEnumeration;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;

public class SPT010_byStringsTest extends SPTTest {
    @Test
    public void split() {
        SplitTextOptions options = new SplitTextOptionsBuilder()
                .range("A1:A18")
                .splitValuesType(SplitValuesTypeEnumeration.BY_STRINGS)
                .strings("OR", "AND", "NOT", "-", "/", "(")
                .treatConsecutiveDelimitersAsOne(true)
                .build();
        execute(options);
        checkResult();
    }


    @Override
    protected void restoreInitialDocumentState() {
        clickUndo(2);
    }
}
