package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        clickOnElement(By.xpath("//a[contains(text(),'Log in')]"));
        //this is from requirement
        String expectedMessage = "Welcome, Please Sign In!";

        //find the welcome text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        //validate actual and expected message
        Assert.assertEquals("not navigate to login page", expectedMessage, actualMessage);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //loginLink.click();
        clickOnElement(By.linkText("Log in"));

        //find email element and enter text using sendkeys method
        sendTextToElement(By.id("Email"), "jj12123@yahoo.com");
        sendTextToElement(By.name("Password"), "nopcommerce");
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        String expectedDisplay = "Log out";
        String actualDisplay = getTextFromElement(By.className("ico-logout"));

        Assert.assertEquals("Not matching", expectedDisplay, actualDisplay);

    }

    @Test
    public void verifyTheErrorMessage() {

        // Find log in link and click on login link
        clickOnElement(By.linkText("Log in"));
        // Find the email field element
        sendTextToElement(By.id("Email"), "prime123@gmail.com");
        // Find the password field element
        sendTextToElement(By.name("Password"), "Prime123");
        //Find the login button and click on it
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage =
                getTextFromElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        // Validate actual and expected message
        Assert.assertEquals("Error message not displayed", expectedErrorMessage, actualErrorMessage);
    }

    @After
    public void tearDown() {

        closeBrowser();
    }


}
