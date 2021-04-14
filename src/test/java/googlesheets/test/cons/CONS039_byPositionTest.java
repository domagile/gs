package googlesheets.test.cons;

import googlesheets.model.consolidatesheets.ConsolidateSheetsOptionBuilder;
import googlesheets.model.consolidatesheets.ConsolidateSheetsOptions;
import googlesheets.test.cons.CONSTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.consolidatesheets.ConsolidationFunctionEnumeration.MIN;
import static googlesheets.model.consolidatesheets.ConsolidationTypeEnumeration.BY_LABEL;
import static googlesheets.model.consolidatesheets.ConsolidationTypeEnumeration.BY_POSITION;

public class CONS039_byPositionTest extends CONSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1mwbcTOxaDWVq2OfdwU6RBq7hZT0d1ljlBQdB_g_zYUo/edit#gid=795301200");
    }

    @Test
    public void consolidate()
    {
        ConsolidateSheetsOptions options = new ConsolidateSheetsOptionBuilder()
                .consolidatedSheets(1, 2, 3)
                .consolidationFunction(MIN)
                .consolidationType(BY_POSITION)
                .build();
        execute(options);
        checkResult();
    }
}
