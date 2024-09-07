package eCommerceLive;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


import java.util.concurrent.TimeUnit;


public class BaseClass {
    public WebDriver driver ;
    String baseUrl;
    @BeforeTest
    public void initializeDriver() {
        driver = new FirefoxDriver();
        baseUrl = "http://live.techpanda.org/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // 1- open home page
        driver.get(baseUrl);

    }
      @AfterTest
    public void teardown ()
    {   if (driver != null) {
        driver.quit();
    } }

}
