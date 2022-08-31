package tests;

import com.aventstack.extentreports.ExtentTest;
import factory.BaseTest;
import factory.DataManager;
import factory.ExtentTestManager;
//import factory.baseTest_NormalDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.amazonCustServ;
import pages.Fashion;
import pages.amazonNextSlide;
import pages.amazonPages;
import utilities.webUtils;

import java.io.IOException;
import java.util.HashMap;

public class amazonTests extends BaseTest {


    @Test(dataProvider = "data", dataProviderClass = DataManager.class)
    public void searchMobilePhones(HashMap<String,String> data) throws InterruptedException, IOException {
        //amazonPages amazon = PageFactory.initElements(getDriver(), amazonPages.class);
        ExtentTest log=ExtentTestManager.getTest();
        amazonPages amazon = new amazonPages(getDriver(), log);
        //amazonPages amazon = new amazonPages(DriverManager.getDriver(), log);
        amazon.openAmazon("https://www.amazon.in/");
        amazon.search(data);
       //log.info("Sample", MediaEntityBuilder.createScreenCaptureFromBase64String(webUtils.captureScreenShot(getDriver())).build());
        log.info(webUtils.captureScreenShot(getDriver()));
        log.info("Map Return : "+data.get("Status"));
    }

    @Test(dataProvider = "data", dataProviderClass = DataManager.class)
    public void searchLaptops(HashMap<String,String> data) throws InterruptedException, IOException {
        //amazonPages amazon = PageFactory.initElements(getDriver(), amazonPages.class);
        ExtentTest log=ExtentTestManager.getTest();
        amazonPages amazon = new amazonPages(getDriver(), log);
        //getDriver().get("https://www.amazon.in/");
        amazon.openAmazon("https://www.amazon.in/");
        amazon.search(data);
        //log.pass(webUtils.captureScreenShot(getDriver()));
        log.info(webUtils.captureScreenShot(getDriver()));
        log.info("Map Return : "+data.get("Status"));
    }

//    @Test
//    public void clickNextCapture()
//    {
//        ExtentTest log=ExtentTestManager.getTest();
//        amazonNextSlide amazon = new amazonNextSlide(getDriver(), log);
//        amazonPages amazonMain = new amazonPages(getDriver(), log);
//        amazonMain.openAmazon("https://www.amazon.in/");
//        amazon.clickCaptureNextSlide();
//    }

    @Test
    public void CustomerPage()
    {
        ExtentTest log=ExtentTestManager.getTest();
        amazonCustServ amazon = new amazonCustServ(getDriver(), log);
        amazonPages amazonMain = new amazonPages(getDriver(), log);
        amazonMain.openAmazon("https://www.amazon.in/");
        Assert.assertTrue(false);
        amazon.navigateCustomerService();

    }

    @Test
    public void FashionPage()
    {
        ExtentTest log=ExtentTestManager.getTest();
        Fashion amazon = new Fashion(getDriver(), log);
        amazonPages amazonMain = new amazonPages(getDriver(), log);
        amazonMain.openAmazon("https://www.amazon.in/");
        amazon.navigateToHealth();
    }
}
