package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.webUtils;

public class amazonNextSlide {
    WebDriver driver;
    ExtentTest logger;
    public amazonNextSlide(WebDriver driver,ExtentTest log)
    {
        this.driver=driver;
        this.logger= log;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a/i/span[text()='Next slide']")
    WebElement nextSlide;

    public void clickCaptureNextSlide()
    {
        nextSlide.click();
        logger.pass("Capture Next Slide Pic :<br>" + webUtils.captureScreenShot(driver));
    }
}
