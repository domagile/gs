package googlesheets.test.text.remove;

import googlesheets.model.text.remove.RemovalTypeEnumeration;
import googlesheets.model.text.remove.RemoveTextOptions;
import googlesheets.model.text.remove.RemoveTextOptionsBuilder;
import googlesheets.model.text.remove.SubstringCharacterRemovalSubtypeEnumeration;
import org.junit.Test;

public class RT001_substringsTest extends RTTest {
    @Test
    public void remove() {
        RemoveTextOptions options = new RemoveTextOptionsBuilder()
                .range("A2:C94")
                .removalType(RemovalTypeEnumeration.SUBSTRINGS_OR_CHARACTERS)
                .substringCharacterRemovalSubtype(SubstringCharacterRemovalSubtypeEnumeration.SUBSTRINGS)
                .substrings(" Bar ")
                .build();
        execute(options);
        checkResult();
    }
}
