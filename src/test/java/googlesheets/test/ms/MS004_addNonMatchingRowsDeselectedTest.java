package googlesheets.test.ms;

import googlesheets.model.generic.rowselection.PairSelection;
import googlesheets.model.generic.rowselection.TripleSelection;
import googlesheets.model.mergesheets.MergeSheetsActionEnumeration;
import googlesheets.model.mergesheets.MergeSheetsOptionBuilder;
import googlesheets.model.mergesheets.MergeSheetsOptions;
import org.junit.BeforeClass;
import org.junit.Test;

public class MS004_addNonMatchingRowsDeselectedTest extends MSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1QRdjIo-hBVKPhjb06WX-vFds6gUbHM2xJE-Nv1fqx58/edit#gid=1027841536");
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
                .matchingColumns(new PairSelection<>(1, "ID"))
                .updatedColumns(new TripleSelection<>(2, MergeSheetsActionEnumeration.UPDATE_VALUES_IN, "Name"),
                        new TripleSelection<>(3, MergeSheetsActionEnumeration.UPDATE_VALUES_IN, "Address"),
                        new TripleSelection<>(4, MergeSheetsActionEnumeration.ADD_TO_END, null))
                .addNonMatchingRows(false)
                .build();
        execute(options);
        checkResult();
    }
}
