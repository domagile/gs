package googlesheets.test.cons;

import googlesheets.model.consolidatesheets.ConsolidateSheetsOptionBuilder;
import googlesheets.model.consolidatesheets.ConsolidateSheetsOptions;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.consolidatesheets.ConsolidationFunctionEnumeration.SUM;
import static googlesheets.model.consolidatesheets.ConsolidationTypeEnumeration.BY_LABEL;

public class CONS001_byHeaderLabelTest extends CONSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1pgxHbmm4BVrqwVOdSgrqYvMWP1yz89BYqIMwBMbJ2Hg/edit#gid=1667291111");
    }

    @Test
    public void consolidate()
    {
        ConsolidateSheetsOptions options = new ConsolidateSheetsOptionBuilder()
                .consolidatedSheets(1, 2, 3)
                .consolidationFunction(SUM)
                .consolidationType(BY_LABEL)
                .useHeaderLabel(true)
                .build();
        execute(options);
        checkResult();
    }
}
