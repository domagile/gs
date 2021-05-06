package googlesheets.service.technical.api;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

public class Context {
    public static final String APPLICATION_NAME = "gs autotests";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();


    public static JsonFactory getJsonFactory()
    {
        return JSON_FACTORY;
    }

}
