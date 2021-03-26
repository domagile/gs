package googlesheets.service;

public class GlobalContext {
    public static final boolean IS_POWER_TOOLS_MODE = false;
    public static final boolean USE_CUSTOM_LINKS = false;
    public static final boolean TEST_RC_VERSION = false;

    private static GlobalContext instance;
    private static boolean isLoggedIn;

    public static synchronized GlobalContext getInstance()
    {
        if (instance == null) {
            instance = new GlobalContext();
        }
        return instance;
    }


    public static void clearInstance()
    {
        instance = null;
    }


    public boolean isLoggedIn() {
        return isLoggedIn;
    }


    public void setLoggedIn(boolean isLoggedIn) {
        GlobalContext.isLoggedIn = isLoggedIn;
    }
}
