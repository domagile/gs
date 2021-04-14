package googlesheets.test.cons;

import googlesheets.model.consolidatesheets.ConsolidateSheetsOptionBuilder;
import googlesheets.model.consolidatesheets.ConsolidateSheetsOptions;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.consolidatesheets.ConsolidationFunctionEnumeration.STDEVP;
import static googlesheets.model.consolidatesheets.ConsolidationFunctionEnumeration.VAR;
import static googlesheets.model.consolidatesheets.ConsolidationTypeEnumeration.BY_LABEL;

public class CONS010_byHeaderLabelTest extends CONSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1I4dfSZrvEvHJtLYrQHxn88vfLd3BEEgD4pK27eb1WM0/edit#gid=0");
    }

    @Test
    public void consolidate()
    {
        ConsolidateSheetsOptions options = new ConsolidateSheetsOptionBuilder()
                .consolidatedSheets(1, 2, 3)
                .consolidationFunction(VAR)
                .consolidationType(BY_LABEL)
                .useHeaderLabel(true)
                .build();
        execute(options);
        checkResult();
    }
}
