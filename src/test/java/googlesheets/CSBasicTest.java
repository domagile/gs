package googlesheets;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.service.combinesheets.CombineSheetsOptions;
import googlesheets.service.combinesheets.ResultLocation;
import googlesheets.test.SpreadsheetTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.combinesheets.CombineSheetsService.*;

public class CSBasicTest extends SpreadsheetTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1sGJ6rkqyegcBIyJn1JNIwPTNmtDb1ACsJFRM0hYnAkU/edit#gid=0");
    }


    @Override
    protected String getSpreadsheetName() {
        return "CS_Basic";
    }

    @Test
    public void combineByHeader() throws IOException, InterruptedException {
        runCombineSheets();
        selectSheetsToCombine(1, 2);

        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .considerTableHeaders(true)
                .resultLocation(ResultLocation.NEW_SHEET).build();
        selectAdditionalOptions(options);

        clickCombineAndClose();
        checkResult("Combined data", "combinesheets_merge_by_header.csv");
    }


    @Test
    public void combineWithoutHeader() throws IOException, InterruptedException {
        runCombineSheets();

        selectSheetsToCombine(1, 2);

        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .considerTableHeaders(false)
                .resultLocation(ResultLocation.NEW_SHEET).build();
        selectAdditionalOptions(options);
        clickCombineAndClose();

        checkResult("Combined data", "combinesheets_merge_without_header.csv");
    }

    @Test
    public void combineWithoutHeader_SeparateByRow() throws IOException, InterruptedException {
        runCombineSheets();

        selectSheetsToCombine(1, 2);

        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .considerTableHeaders(false)
                .separateByBlankRow(true)
                .resultLocation(ResultLocation.NEW_SHEET).build();
        selectAdditionalOptions(options);
        clickCombineAndClose();

        checkResult("Combined data", "combinesheets_withoutheader_separatedbyrow.csv");
    }


    @Test
    public void combineByHeader_SeparateByRow() throws IOException, InterruptedException {
        runCombineSheets();

        selectSheetsToCombine(1, 2);

        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .considerTableHeaders(true)
                .separateByBlankRow(true)
                .resultLocation(ResultLocation.NEW_SHEET).build();
        selectAdditionalOptions(options);
        clickCombineAndClose();

        checkResult("Combined data", "combinesheets_withheader_separatedbyrow.csv");
    }
}



