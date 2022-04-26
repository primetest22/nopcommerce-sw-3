package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {

        //find register link element
        clickOnElement(By.linkText("Register"));

        String expectedDisplay = "Register";
        String actualDisplay = getTextFromElement(By.xpath("//a[contains(text(),'Register')]"));
        //validate actual and expected message
        Assert.assertEquals("not matching", expectedDisplay, actualDisplay);
    }

    @Test
    public void userSholdRegisterAccountSuccessfully() throws InterruptedException {

        //find element for register link
        clickOnElement(By.linkText("Register"));

        //find gender radio button element
        clickOnElement(By.xpath("//input[@id='gender-male']"));

        sendTextToElement(By.id("FirstName"), "Prime");
        sendTextToElement(By.id("LastName"), "Test");

        //find dropdown element for day using select
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[1]/option[5]"));

        selectByVisibleTextFromDropDown(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[1]"), "1");
        Thread.sleep(1000);
        //find dropdown element for month using select
        selectByVisibleTextFromDropDown(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[2]"), "January");
        Thread.sleep(1000);
        //find dropdown element for year using select
        selectByVisibleTextFromDropDown(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[3]"), "2000");
        Thread.sleep(1000);
        //send text to element
        sendTextToElement(By.id("Email"), "jj121234@yahoo.com");
        sendTextToElement(By.id("Password"), "nopcommerce");
        sendTextToElement(By.id("ConfirmPassword"), "nopcommerce");

        clickOnElement(By.id("register-button"));

        String expectedDisplay = "Your registration completed";
        String actualDisplay = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        //validate message
        Assert.assertEquals("not matching", expectedDisplay, actualDisplay);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
