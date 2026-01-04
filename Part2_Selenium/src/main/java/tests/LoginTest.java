package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import junit.framework.Assert;
import pages.Login;

public class LoginTest {

    @Test
    public void TC1_Positive_LogIn_Test() {
        String expected_url = "practicetestautomation.com/logged-in-successfully/";
        String expected_heading = "Logged In Successfully";
        String expected_text_1 = "Congratulations";
        String expected_text_2 = "successfully logged in";
        String expected_logOut = "Log out";

        WebDriver myBrowser = new ChromeDriver();
        myBrowser.get("https://practicetestautomation.com/practice-test-login/");

        Login login = new Login(myBrowser);
        login.usernameBlock.sendKeys("student");
        login.passwordBlock.sendKeys("Password123");
        login.submitButton.click();

        String actual_url = myBrowser.getCurrentUrl();
        Assert.assertTrue(actual_url.contains(expected_url));

        String actual_heading = myBrowser.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(actual_heading, expected_heading);

        String pageText = myBrowser.findElement(By.tagName("body")).getText();
        Assert.assertTrue(pageText.contains(expected_text_1) || pageText.contains(expected_text_2));

        WebElement logoutButton = myBrowser.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        String actual_logoutText = logoutButton.getText();
        Assert.assertEquals(actual_logoutText, expected_logOut);

        myBrowser.quit();
    }

    @Test
    public void TC2_Negative_username_test() {
        String expected_errorMessage = "Your username is invalid!";

        WebDriver myBrowser = new ChromeDriver();
        myBrowser.get("https://practicetestautomation.com/practice-test-login/");

        Login login = new Login(myBrowser);
        login.usernameBlock.sendKeys("incorrectUser");
        login.passwordBlock.sendKeys("Password123");
        login.submitButton.click();

        String actual_errorMessage = myBrowser.findElement(By.id("error")).getText();
        Assert.assertEquals(actual_errorMessage, expected_errorMessage);

        String actual_url = myBrowser.getCurrentUrl();
        Assert.assertTrue(actual_url.contains("practice-test-login"));

        myBrowser.quit();
    }

    @Test
    public void TC3_Negative_password_test() {
        String expected_errorMessage = "Your password is invalid!";

        WebDriver myBrowser = new ChromeDriver();
        myBrowser.get("https://practicetestautomation.com/practice-test-login/");

        Login login = new Login(myBrowser);
        login.usernameBlock.sendKeys("student");
        login.passwordBlock.sendKeys("incorrectPassword");
        login.submitButton.click();

        String actual_errorMessage = myBrowser.findElement(By.id("error")).getText();
        Assert.assertEquals(actual_errorMessage, expected_errorMessage);

        String actual_url = myBrowser.getCurrentUrl();
        Assert.assertTrue(actual_url.contains("practice-test-login"));

        myBrowser.quit();
    }
}
