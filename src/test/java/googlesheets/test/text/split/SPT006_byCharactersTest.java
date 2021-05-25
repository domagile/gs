package googlesheets.test.text.split;

import googlesheets.model.text.split.SplitTextOptions;
import googlesheets.model.text.split.SplitTextOptionsBuilder;
import googlesheets.model.text.split.SplitValuesTypeEnumeration;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;

public class SPT006_byCharactersTest extends SPTTest {
    @Test
    public void split() {
        SplitTextOptions options = new SplitTextOptionsBuilder()
                .range("C1:C32")
                .splitValuesType(SplitValuesTypeEnumeration.BY_CHARACTERS)
                .space(true)
                .lineBreak(true)
                .comma(true)
                .semicolon(true)
                .customOption(true)
                .customCharacters("@.()\"/_#")
                .build();
        execute(options);
        checkResult();
    }


    @Override
    protected void restoreInitialDocumentState() {
        clickUndo(2);
    }
}
