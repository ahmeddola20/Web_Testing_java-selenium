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

public  class testcase05 extends BaseClass{

    @Test
    public void testDay5TestCase5() throws Exception {

//        public void Register ()
//        {   // navigate to Registration Page
//            driver.findElement(By.linkText("Register")).click();
//
//            // verify the URL
//            String  expectedURL = "https://demo.nopcommerce.com/register?returnUrl=%2F" ;
//            String  actualURL = driver.getCurrentUrl();
//            Assert.assertEquals(actualURL,expectedURL,"URL does not match");
//
//            // verify the Page Title
//            String expectedTitle = "nopCommerce demo store. Register" ;
//            String actualTitle = driver.getTitle();
//            Assert.assertEquals(actualTitle,expectedTitle,"Page title does not match");
//
//            // verify the presence of the Registration button
//            WebElement RegisterButt = driver.findElement(By.id("register-button"));
//            Assert.assertTrue(RegisterButt.isDisplayed(),"Register button is not displayed ");
//
//            // verify the presence of first name field
//            WebElement firstName = driver.findElement(By.id("FirstName"));
//            Assert.assertTrue(firstName.isDisplayed(),"First name Field is not displayed");
//            // Assert.assertTrue(driver.findElement(By.partialLinkText("Your")).isDisplayed());
//
//        }

    // Step 2 .  select Register from Account list
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Register")).click();
//    // Step 3 .  Fill in Registration form with valid data
        driver.findElement(By.name("firstname")).sendKeys("dola");
        driver.findElement(By.name("middlename")).sendKeys("atef");
        driver.findElement(By.name("lastname")).sendKeys("boda");
        driver.findElement(By.name("email")).sendKeys("exampel3@gmail.com");
        driver.findElement(By.name("password")).sendKeys("c");
        driver.findElement(By.name("confirmation")).sendKeys("0235712992");
        driver.findElement(By.xpath("//button[@title=\"Register\"]")).click();
// Step 4 .  Verify Registration Success Message
        String registere_mssg = driver.findElement(By.xpath("//*[@class=\"messages\"]")).getText();
        System.out.println(registere_mssg);

        }



}








