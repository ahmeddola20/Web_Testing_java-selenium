package eCommerceLive;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class login extends BaseClass {
    public int scc = 0;

    private final StringBuffer verificationErrors = new StringBuffer();

    @Test
    public void Login() throws Exception {
        driver.findElement(By.cssSelector(".btn-share")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Log In")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // step 2 .  fill in login form with valid data
        driver.findElement(By.id("email")).sendKeys("exampel3@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("0235712992");
        driver.findElement(By.id("send2")).submit();
    }

 }

