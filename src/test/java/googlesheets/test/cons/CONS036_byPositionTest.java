package googlesheets.test.cons;

import googlesheets.model.consolidatesheets.ConsolidateSheetsOptionBuilder;
import googlesheets.model.consolidatesheets.ConsolidateSheetsOptions;
import googlesheets.test.cons.CONSTest;
import org.junit.Test;

import static googlesheets.model.consolidatesheets.ConsolidationFunctionEnumeration.COUNTA;
import static googlesheets.model.consolidatesheets.ConsolidationTypeEnumeration.BY_POSITION;

public class CONS036_byPositionTest extends CONSTest {
    @Test
    public void consolidate()
    {
        ConsolidateSheetsOptions options = new ConsolidateSheetsOptionBuilder()
                .consolidatedSheets(1, 2, 3)
                .consolidationFunction(COUNTA)
                .consolidationType(BY_POSITION)
                .build();
        execute(options);
        checkResult();
    }
}
