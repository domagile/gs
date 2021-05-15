package googlesheets.service.generic.addon;

import googlesheets.service.GlobalContext;
import org.openqa.selenium.WebDriverException;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;

import static googlesheets.service.generic.google.GoogleSheetService.sleep;

public class FunctionReinvocationUtil {
    public static void reinvokeFunctionWithDelay(Runnable function) {
        sleep(1000);
        function.run();
    }

    public static <T> void reinvokeFunctionWithDelay(Consumer<T> function, T parameter) {
        sleep(1000);
        function.accept(parameter);
    }

    public static <T, R> R reinvokeFunctionWithDelay(Function<T, R> function, T parameter) {
        sleep(1000);
        return function.apply(parameter);
    }


    public static <T> void invokeFunctionWithReinvocation(Consumer<T> function, T parameter, Class<? extends WebDriverException>... exceptionTypes) {
        try {
            function.accept(parameter);
        } catch (WebDriverException e) {
            if (Arrays.stream(exceptionTypes).noneMatch(type -> type.isInstance(e)))
                throw e;
            if (GlobalContext.getInstance().registerFunctionInvocation(function)) {
                sleep(1000);
                invokeFunctionWithReinvocation(function, parameter, exceptionTypes);
            }
        }
    }


    public static <T, U> void invokeFunctionWithReinvocation(BiConsumer<T, U> function, T parameter1, U parameter2,
                                                             Class<? extends WebDriverException>... exceptionTypes) {
        try {
            function.accept(parameter1, parameter2);
        } catch (WebDriverException | FunctionInvocationException e) {
            if (Arrays.stream(exceptionTypes).noneMatch(type -> type.isInstance(e))
                    && !(e instanceof FunctionInvocationException))
                throw e;
            if (GlobalContext.getInstance().registerFunctionInvocation(function)) {
                sleep(1000);
                invokeFunctionWithReinvocation(function, parameter1, parameter2, exceptionTypes);
            }
        }
    }


    public static <T> void invokeFunctionWithReinvocation(Runnable function, Class<? extends WebDriverException>... exceptionTypes) {
        try {
            function.run();
        } catch (WebDriverException | FunctionInvocationException e) {
            if (Arrays.stream(exceptionTypes).noneMatch(type -> type.isInstance(e))
                    && !(e instanceof FunctionInvocationException))
                throw e;
            if (GlobalContext.getInstance().registerFunctionInvocation(function)) {
                sleep(1000);
                invokeFunctionWithReinvocation(function, exceptionTypes);
            }
        }
    }


    public static <T> void invokeFunctionWithReinvocation(BooleanSupplier function) {
        if (!function.getAsBoolean()) {
            sleep(1000);
            invokeFunctionWithReinvocation(function);
        }
    }
}
