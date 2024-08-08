package eCommerceLive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testcase02 {
    private WebDriver driver;
    private String baseUrl;
    String product_list_value ;
    String product_details_value ;

    private final StringBuffer verificationErrors = new StringBuffer();

    @BeforeMethod
    @BeforeTest
    public void setUp() throws Exception {
       // System.setProperty("webdriver.gecko.driver", "C:\\Users\\ahmed\\IdeaProjects\\Guru99_Tasks\\src\\main\\resources\\geckodriver.exe"); // Ensure the path to geckodriver is correct
        driver = new FirefoxDriver();
        baseUrl = "http://live.techpanda.org/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testDay2TestCase2() throws Exception {
// 1- open home page
        driver.get(baseUrl);
         // Step 2 . Click on "MOBILE" menu
        driver.findElement(By.linkText("MOBILE")).click();

        // Step 3 . In the list of mobile read the cost of sony xperia mobile note the value it returns $100
         product_list_value = driver.findElement(By.id("product-price-1")).getText();
      //  System.out.println(product_list_value);

        // Step 4 . Verify the cost of sony xperia mobile   $100
        driver.findElement(By.xpath("//a[@title=\"Sony Xperia\"]")).click();
        // Step 5 . read the cost of sony xperia mobile   $100
         product_details_value = driver.findElement(By.id("product-price-1")).getText();
         //   System.out.println(product_details_value);
            //Step 6 . Verify the cost of sony xperia mobile   $100
            Assert.assertEquals(product_details_value, product_list_value);
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();

        }
    }


