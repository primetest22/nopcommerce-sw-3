package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {

        //find computer element
        clickOnElement(By.linkText("Computers"));

        String expectedDisplay = "Computers";
        String actualDisplay = getTextFromElement(By.xpath("//h1[contains(text(),'Computers')]"));

        Assert.assertEquals("not matching", expectedDisplay, actualDisplay);

    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {

        //find electronics element
        clickOnElement(By.linkText("Electronics"));

        String expectedDisplay = "Electronics";
        String actualDisplay = getTextFromElement(By.xpath("//h1[contains(text(),'Electronics')]"));

        Assert.assertEquals("not matching", expectedDisplay, actualDisplay);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {

        //find apparel element
        clickOnElement(By.linkText("Apparel"));

        String expectedDisplay = "Apparel";
        String actualDisplay = getTextFromElement(By.xpath("//h1[contains(text(),'Apparel')]"));

        Assert.assertEquals("not matching", expectedDisplay, actualDisplay);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {

        //find digitaldownload element
        clickOnElement(By.linkText("Digital downloads"));

        String expectedDisplay = "Digital downloads";
        String actualDisplay = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]"));

        Assert.assertEquals("not matching", expectedDisplay, actualDisplay);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {

        //find books element
        clickOnElement(By.linkText("Books"));

        String expectedDisplay = "Books";
        String actualDisplay = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[5]/a[1]"));

        Assert.assertEquals("not matching", expectedDisplay, actualDisplay);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {

        //find jewelry element
        clickOnElement(By.linkText("Jewelry"));

        String expectedDisplay = "Jewelry";
        String actualDisplay = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[6]/a[1]"));

        Assert.assertEquals("not matching", expectedDisplay, actualDisplay);
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {

        //find gift cards element
        clickOnElement(By.linkText("Gift Cards"));

        String expectedDisplay = "Gift Cards";
        String actualDisplay = getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]"));

        Assert.assertEquals("not matching", expectedDisplay, actualDisplay);
    }

    @After
    public void tearDown() {

        closeBrowser();
    }


}
