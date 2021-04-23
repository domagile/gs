package googlesheets.test.ms;

import googlesheets.model.generic.rowselection.PairSelection;
import googlesheets.model.generic.rowselection.TripleSelection;
import googlesheets.model.mergesheets.MergeSheetsActionEnumeration;
import googlesheets.model.mergesheets.MergeSheetsOptionBuilder;
import googlesheets.model.mergesheets.MergeSheetsOptions;
import org.junit.BeforeClass;
import org.junit.Test;

public class MS002_oneFieldDateTest extends MSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1eDjGH_n0fGxqEjWLk4WP2Vig1Lgy4VBb9GJn4hinsvY/edit#gid=2022891138");
    }


    @Test
    public void merge()
    {
        MergeSheetsOptions options = new MergeSheetsOptionBuilder()
                .mainSheet("Master")
                .mainTableRange("B2:D6")
                .lookupSheet("Lookup")
                .lookupTableRange("B2:E8")
                .mainTableHasHeaders(true)
                .lookupTableHasHeaders(true)
                .matchingColumns(new PairSelection<>(1, "Date"))
                .updatedColumns(new TripleSelection<>(2, MergeSheetsActionEnumeration.UPDATE_VALUES_IN, "Name"))
                .addNonMatchingRows(true)
                .build();
        execute(options);
        checkResult();
    }
}
