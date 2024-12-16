package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WebEventListener implements WebDriverListener {

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        WebDriverListener.super.onError(target, method, args, e);
    }

    @Override
    public void beforeGet(WebDriver driver, String url) {
        System.out.println("Begin to get url: "+ url);
    }
}
