package googlesheets.test.afr;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.getResultListName;
import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;

public class AFR001_ValuesNumberTest extends AFRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
       GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1wXhDHPNarDutnSz-CQk1yaA7D-W6GC3-odsi_-Zf9lw/edit#gid=1061966272");
//       GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1wXhDHPNarDutnSz-CQk1yaA7D-W6GC3-odsi_-Zf9lw/edit?addon_dry_run=AAnXSK-pxZlrDKoBeN09z-YQNMGGM_imH7HPIj9pkS9OqNs26JiYNxBV6ngjxQM0g_smFSXW6L2dmRNyGy6MtbNaCbCic2gPO2RIc5evGxJmtAkYVfHhkrE40B-M_67_NrN3CNxehkBJ#gid=1061966272");
//       GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1z2ppCCSqI7JR9uCSrqjybSmy3KchM5HdMjVUD88ITYw/edit?addon_dry_run=AAnXSK_C-c9CqtFvkG5WYzmNHkW0jxqmjwvDuqE0mc6VZIcPp07H_z6sU7HQYEMtf4e1nEW6-StTulAVkcs1NpXobGs9tO1HpB_btG0QISLiuyIJhoiM--AH9JSRCs2lZjjwAIRHksnf#gid=1188486544");

    }

    @Test
    public void valuesNumber() throws IOException, InterruptedException {
        runAdvancedFindAndReplace();
        //fill it first because other fields are reloaded after loading of this table
        setSearchIn(SearchInSelection.SELECTED_LISTS, 2);

        setSearchString("600");
        setMatchCase(false);
        setEntireCell(false);
        setByMask(false);

        setValues(true);
        setFormulas(false);
        setNotes(false);
        setHyperlinks(false);
        setErrors(false);

        clickFindAll();
        runExportAllFoundEntries();
        String resultListName = getResultListName("Export results ");
        checkResult(resultListName, "advancedfindreplace\\AFR_001_valuesNumberAllSheets.csv");
    }
}
