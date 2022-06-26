package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.webUtils;

public class amazonCustServ {
    WebDriver driver;
    ExtentTest logger;
    public amazonCustServ(WebDriver driver, ExtentTest log)
    {
        this.driver=driver;
        this.logger= log;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Customer Service']")
    WebElement fresh;

    public void navigateCustomerService()
    {
        fresh.click();
        logger.pass("Customer Service:<br> " + webUtils.captureScreenShot(driver));
    }
}
