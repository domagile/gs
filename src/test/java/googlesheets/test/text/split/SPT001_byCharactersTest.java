package googlesheets.test.text.split;

import googlesheets.model.text.split.SplitTextOptions;
import googlesheets.model.text.split.SplitTextOptionsBuilder;
import googlesheets.model.text.split.SplitValuesTypeEnumeration;
import org.junit.BeforeClass;
import org.junit.Test;

public class SPT001_byCharactersTest extends SPTTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/17l0vFgDqMpCuWcAndNagY0TJ2M1OYd3UVpqXknpZQPM/edit#gid=1996497916");
    }

    @Test
    public void split() {
        SplitTextOptions options = new SplitTextOptionsBuilder()
                .range("B5:B24")
                .splitValuesType(SplitValuesTypeEnumeration.BY_CHARACTERS)
                .space(true)
                .build();
        execute(options);
        checkResult();
    }
}
