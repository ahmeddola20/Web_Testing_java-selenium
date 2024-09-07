package eCommerceLive;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public  class testcase06 extends BaseClass {




    @Test//(dependsOnMethods = {"eCommerceLive.testcase04.testDay4TestCase4"})
    public void testDay6TestCase6() throws Exception {
        // Step 1 . login to the store
        driver.findElement(By.cssSelector(".btn-share")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Log In")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // step 2 .  fill in login form with valid data
        driver.findElement(By.id("email")).sendKeys("exampel3@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("0235712992");
        driver.findElement(By.id("send2")).submit();

        // step 3 .  navigate to TV page
        Thread.sleep(2000);
        driver.findElement(By.linkText("TV")).click();


        // step 3 .  add products to wishlist by "Add to Wish List" button
        try {
            List<WebElement> mobiles = driver.findElements(By.linkText("Add to Wishlist"));
            mobiles.get(0).click();
            mobiles.get(1).click();
        } catch (StaleElementReferenceException e) {
            // Re-locate the element and try again
            List<WebElement> mobiles = driver.findElements(By.linkText("Add to Wishlist"));
            mobiles.get(1).click();
        }
        Thread.sleep(2000);

        // step 4 .  share the wishlist by clicking "Save and Share" button
        driver.findElement(By.xpath("//button[title=\"Add All to Cart\"]")).click();

        Thread.sleep(2000);
        driver.findElement(By.id("email_address")).sendKeys("dola@gmail.com");
        driver.findElement(By.id("message")).sendKeys("hi dola kindly check my wishlist");

        driver.findElement(By.xpath("//button[@type=\"submit\"]")).submit();



    }
// to stop the browser from closing


    @Override
    public void teardown ()
    {   }


}








