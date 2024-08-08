package eCommerceLive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testcase03 {
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
    public void testDay3TestCase3() throws Exception {
        // 1- open home page
        driver.get(baseUrl);

    // Step 2 . Click on "MOBILE" menu
        driver.findElement(By.linkText("MOBILE")).click();

    // Step 3 .  Locate the third "Add to Cart" button
        WebElement add_to_cart_button = driver.findElement(By.xpath("(//button[@title='Add to Cart'])[3]"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        add_to_cart_button.click();

        // verify you are navigating to the correct page of "Sony Xperia - Mobile"
       String  current_page = driver.findElement(By.cssSelector("h2")).getText();
        Assert.assertEquals(current_page, "SONY XPERIA");
    // Step 4 .  Locate the "Update Cart" button
     // WebElement ADD_To_cart_button = driver.findElement(By.xpath("//button[@title=\"Add to Cart\"]"));
        //  ADD_To_cart_button.click();

    // 4- Change the QTY vaLue to 100 and click update button
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/input")).sendKeys("1000");
        driver.findElement(By.xpath("//button[@title='Update']")).click();


       String error_MSSG = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[2]/p")).getText();
    //System.out.println(error_MSSG);
    // Step 5 . Verify the error message "Quantity can not be greater than 100"
        Assert.assertEquals(error_MSSG, "* The maximum quantity allowed for purchase is 500.");

    // Step 6 . empty the QTY vaLue By clicking empty_cart_button
        driver.findElement(By.id("empty_cart_button")).click();

        String empty_mssg = driver.findElement(By.cssSelector("h1")).getText();
       // System.out.println(empty_mssg);
    // Step 7 . Verify the cart is empty
        Assert.assertEquals(empty_mssg, "SHOPPING CART IS EMPTY");
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();

        }
    }


