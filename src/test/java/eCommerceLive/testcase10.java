package eCommerceLive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public  class testcase10 extends BaseClass {




    @Test (dependsOnMethods = {"eCommerceLive.login.Login"})  // first login then open home page
    public void testDay10TestCase10() throws Exception {
        // Step 1 . open home page
        // Step 2 .  login to the store
        // Step 3 .  navigate to 0 page
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Step 2 . Click on "MOBILE" menu
        driver.findElement(By.linkText("Mobile")).click();

        // Step 3 .  Locate the third "Add to Cart" button
        WebElement add_to_cart_button = driver.findElement(By.xpath("(//button[@title='Add to Cart'])[1]"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        add_to_cart_button.click();

    }


    @Override
    public void teardown ()
    {   }

}








