package googlesheets.test.cons;

import googlesheets.model.consolidatesheets.ConsolidateSheetsOptionBuilder;
import googlesheets.model.consolidatesheets.ConsolidateSheetsOptions;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.consolidatesheets.ConsolidationFunctionEnumeration.MIN;
import static googlesheets.model.consolidatesheets.ConsolidationFunctionEnumeration.SUM;
import static googlesheets.model.consolidatesheets.ConsolidationTypeEnumeration.BY_LABEL;

public class CONS006_byHeaderLabelTest extends CONSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1XZYo3OT-C20IMn9Omte-OJmpgqpuBm0wp1IRbU_PfVA/edit#gid=0");
    }

    @Test
    public void consolidate()
    {
        ConsolidateSheetsOptions options = new ConsolidateSheetsOptionBuilder()
                .consolidatedSheets(1, 2, 3)
                .consolidationFunction(MIN)
                .consolidationType(BY_LABEL)
                .useHeaderLabel(true)
                .build();
        execute(options);
        checkResult();
    }
}
