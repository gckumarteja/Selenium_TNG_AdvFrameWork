package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.webUtils;

public class Fashion {
    WebDriver driver;
    ExtentTest logger;
    public Fashion(WebDriver driver, ExtentTest log)
    {
        this.driver=driver;
        this.logger= log;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Fashion']")
    WebElement Fashion;

    public void navigateToHealth()
    {
        Fashion.click();
        logger.pass("Fashion:<br> " + webUtils.captureScreenShot(driver));
    }
}
