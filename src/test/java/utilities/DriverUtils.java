package utilities;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;

public class DriverUtils {
    public static void navigate(String url){
        Browser browser = AqualityServices.getBrowser();
        browser.maximize();
        browser.goTo(url);
        browser.waitForPageToLoad();
    }

    public static void addCookie(String cookieName, String cookieValue){
        Cookie cookie = new Cookie(cookieName, cookieValue);
        AqualityServices.getBrowser().getDriver().manage().addCookie(cookie);
    }

    public static void refresh(){
        AqualityServices.getBrowser().getDriver().navigate().refresh();
    }


    public static void closeTab(){
        AqualityServices.getBrowser().getDriver().close();
    }

    public static void changeTab(int tabNumber){
        ArrayList<String> tabs = new ArrayList<>(AqualityServices.getBrowser().getDriver().getWindowHandles());
        AqualityServices.getBrowser().getDriver().switchTo().window(tabs.get(tabNumber));
    }

    public static byte[] takeScreenshot(){
        return AqualityServices.getBrowser().getScreenshot();
    }

    public static void quit(){
        AqualityServices.getBrowser().quit();
    }
}
