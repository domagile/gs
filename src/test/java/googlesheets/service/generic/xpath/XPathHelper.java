package googlesheets.service.generic.xpath;

public class XPathHelper {
    public static String textIs(String text)
    {
        return String.format("//*[text()='%s']", text);
    }


    public static String textContains(String text)
    {
        return String.format("//*[text()[contains(.,'%s')]]", text);
    }


    public static String textContains(String text, String tag)
    {
        return String.format("//%s[text()[contains(.,'%s')]]", tag, text);
    }


    public static String textContainsExceptTag(String text, String tag)
    {
        return String.format("//*[not(self::%s) and text()[contains(.,'%s')]]", tag, text);
    }


    public static String attributeIs(String attributeName, String attributeValue)
    {
        return String.format("//*[@%s='%s']", attributeName, attributeValue);
    }
}
