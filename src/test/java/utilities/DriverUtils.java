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

    public static void quit(){
        AqualityServices.getBrowser().quit();
    }
}
