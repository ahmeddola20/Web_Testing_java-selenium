package eCommerceLive;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public  class testcase05 {
    private WebDriver driver;
    private String baseUrl;

    private final StringBuffer verificationErrors = new StringBuffer();


    @BeforeTest
    public void setUp() throws Exception {
       // System.setProperty("webdriver.gecko.driver", "C:\\Users\\ahmed\\IdeaProjects\\Guru99_Tasks\\src\\main\\resources\\geckodriver.exe"); // Ensure the path to geckodriver is correct
        driver = new FirefoxDriver();
        baseUrl = "http://live.techpanda.org/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testDay4TestCase4() throws Exception {
        // 1- open home page
        driver.get(baseUrl);

    // Step 2 . Click on "MOBILE" menu
        driver.findElement(By.linkText("MOBILE")).click();


    // Step 3 .  select first and second mobiles to compare by "Add to Compare" button

        try {
            List<WebElement> mobiles = driver.findElements(By.linkText("Add to Compare"));
            mobiles.get(0).click();
            mobiles.get(1).click();
        } catch (StaleElementReferenceException e) {
            // Re-locate the element and try again
            List<WebElement> mobiles = driver.findElements(By.linkText("Add to Compare"));
                mobiles.get(1).click();
        }

        // Step 4   .  Locate the "Compare" button and click it

        driver.findElement(By.xpath("//button[@title='Compare']")).click();

        // Step 5 verify you are navigating popup page of "Compare Products"

        // switching to new window
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        // 5. Verify the pop-up window and check that the products are reflected in it
        //    Heading "COMPARE PRODUCTS" with selected products in it.
        String strHead = ("COMPARE PRODUCTS");
        String compHead = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div[1]/h1")).getText();
       Assert.assertEquals(compHead, strHead);
        // to check the popup heading/title

        // 6. Close the Popup Windows
        driver.findElement(By.xpath("//button[@title='Close Window']")).click();

        // switching to new window
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }


    }
    @AfterTest
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
        }







