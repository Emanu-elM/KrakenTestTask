package tests;

import kraken.configuration.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.DriverUtils;

public class BaseTest {
    @BeforeMethod
    public void setup(){
        DriverUtils.navigate(Configuration.startUrl);
    }

    @AfterMethod
    public void tearDown() {
        DriverUtils.quit();
    }
}
