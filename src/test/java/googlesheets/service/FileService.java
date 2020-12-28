package googlesheets.service;

import org.junit.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static void checkFileEquality(String file1Path, String file2Path) throws IOException {
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
                    Assert.fail("Difference in row " + (i + 1));
                }
            }
        }
        finally {
            br1.close();
            br2.close();
        }
    }


    public static void compareFileWithEtalon(String spreadsheetName, String listName, String etalonFileName) throws InterruptedException, IOException {
        //todo: replace with checking of file existance
        Thread.sleep(3000);

        String etalonPath = "src\\test\\resources\\etalon\\";
        FileService.checkFileEquality(getDownloadedFileName(spreadsheetName, listName), etalonPath + etalonFileName);
    }


    public static void removeDownloadedListFile(String spreadsheetName, String listName) {
        new File(getDownloadedFileName(spreadsheetName, listName)).delete();
    }


    private static String getDownloadedFileName(String spreadsheetName, String listName)
    {
        String userDirectory = System.getProperty("user.home");
        return String.format("%s\\Downloads\\%s - %s.csv", userDirectory, spreadsheetName, listName);
    }
}
