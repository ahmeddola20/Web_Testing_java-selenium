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

public  class testcase04 extends BaseClass{

    @Test
    public void testDay4TestCase4() throws Exception {

    // Step 2 . Click on "MOBILE" menu
        driver.findElement(By.linkText("Mobile")).click();


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

        }







