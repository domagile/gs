package googlesheets.service;

public class GlobalContext {
    public static final boolean IS_POWER_TOOLS_MODE = false;
    public static final boolean USE_CUSTOM_LINKS = false;
    public static final boolean TEST_RC_VERSION = false;
    public static final int MAX_REINVOCATION_COUNT = 30;
    public static final int DEFAULT_WORKING_MESSAGE_TIMEOUT = 60;
    public static final boolean USE_SPREADSHEET_API = false;

    private static GlobalContext instance;
    private static boolean isLoggedIn;
    private Object reinvokedFunction;
    private int reinvocationCount;
    private String powerToolsTopIFrameSrc = "";

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


    public boolean registerFunctionInvocation(Object function) {
        if (function == reinvokedFunction) {
            reinvocationCount++;
            if (reinvocationCount > MAX_REINVOCATION_COUNT) {
                return false;
            }
        }
        else {
            reinvokedFunction = function;
            reinvocationCount = 0;
        }
        return true;
    }


    public String getPowerToolsTopIFrameSrc() {
        return powerToolsTopIFrameSrc;
    }

    public void setPowerToolsTopIFrameSrc(String powerToolsTopIFrameSrc) {
        this.powerToolsTopIFrameSrc = powerToolsTopIFrameSrc;
    }
}
