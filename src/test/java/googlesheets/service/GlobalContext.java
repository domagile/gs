package googlesheets.service;

public class GlobalContext {
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


    void setLoggedIn(boolean isLoggedIn) {
        GlobalContext.isLoggedIn = isLoggedIn;
    }
}
