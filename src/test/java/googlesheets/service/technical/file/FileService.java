package googlesheets.service.technical.file;

import ext.poi.examples.ExcelComparator;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static googlesheets.service.generic.google.GoogleSheetService.sleep;

public class FileService {
    private static void checkCSVFileEquality(String file1Path, String file2Path) throws IOException {
        String sCurrentLine;
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        BufferedReader br1 = new BufferedReader(new FileReader(file1Path));
        BufferedReader br2 = new BufferedReader(new FileReader(file2Path));
        try {
            while ((sCurrentLine = br1.readLine()) != null) {
                list1.add(sCurrentLine);
            }
            while ((sCurrentLine = br2.readLine()) != null) {
                list2.add(sCurrentLine);
            }
            if (list1.size() != list2.size()) {
                Assert.fail("Different number of rows");
            }
            for (int i = 0; i < list1.size(); i++) {
                if (!list1.get(i).equals(list2.get(i))) {
                    String message = "Difference in row " + (i + 1) + ":";
                    message += "\nActual row: " + list1.get(i);
                    message += "\nExpected row: " + list2.get(i);
                    Assert.fail(message);
                }
            }
        }
        finally {
            br1.close();
            br2.close();
        }
    }


    private static void checkExcelFileEquality(String file1Path, String file2Path, String listName) throws IOException {
        Workbook workbook1 = WorkbookFactory.create(new File(file1Path), null, true);
        Workbook workbook2 = WorkbookFactory.create(new File(file2Path), null, true);
        List<String> differences = ExcelComparator.compare(workbook1, listName, workbook2, listName);
        if (!differences.isEmpty()) {
            Assert.fail(String.join("\n", differences));
        }
    }


    public static void compareFileWithEtalon(String spreadsheetName, String listName, String etalonFileName) throws IOException {
        compareFileWithEtalon(spreadsheetName, listName, etalonFileName, FileType.CSV);
    }


    public static void compareFileWithEtalon(String spreadsheetName, String listName, String etalonFileName, FileType fileType) throws IOException {
        String downloadedFileName = getDownloadedFileName(spreadsheetName, listName, fileType);
        File downloadedFile = new File(downloadedFileName);
        int maxWaitMillis = 10000;
        int checkTimeMillis = 500;
        for (int i = 0; i < maxWaitMillis; i++) {
            if (downloadedFile.exists()) {
                break;
            }
            sleep(checkTimeMillis);
            i += checkTimeMillis;
        }

        String etalonPath = "src\\test\\resources\\etalon\\";
        switch (fileType) {
            case CSV:
                checkCSVFileEquality(downloadedFileName, etalonPath + etalonFileName);
                break;
            case XLSX:
                checkExcelFileEquality(downloadedFileName, etalonPath + etalonFileName, listName);
                break;
        }
    }


    public static void removeDownloadedListFile(String spreadsheetName, String listName, FileType fileType) {
        new File(getDownloadedFileName(spreadsheetName, listName, fileType)).delete();
    }


    public static boolean fileExists(String spreadsheetName, String listName, FileType fileType) {
        return new File(getDownloadedFileName(spreadsheetName, listName, fileType)).exists();
    }


    public static String getDownloadedFileName(String spreadsheetName, String listName, FileType fileType)
    {
        String userDirectory = System.getProperty("user.home");
        if (fileType == FileType.CSV) {
            return String.format("%s\\Downloads\\%s - %s.%s", userDirectory, spreadsheetName, listName, fileType.toString().toLowerCase());
        }
        else if (fileType == FileType.XLSX) {
            return String.format("%s\\Downloads\\%s.%s", userDirectory, spreadsheetName, fileType.toString().toLowerCase());
        }
        throw new IllegalArgumentException("Unknown file type");
    }
}
