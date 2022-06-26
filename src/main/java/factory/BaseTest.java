package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.PrimitiveIterator;
import java.util.concurrent.TimeUnit;

public class BaseTest {
 /*  private static ThreadLocal<WebDriver> driver =new ThreadLocal<WebDriver>();
    public void setDriver(WebDriver driver)
    {
        this.driver.set(driver);
    }
    public static WebDriver getDriver()
    {
        return  driver.get();
    }*/

    public static WebDriver getDriver()
    {
        return  DriverManager.getInstance().getDriver();
    }

    @BeforeSuite
    public synchronized void SetupExtentReport()
    {
        ExtentManager.createInstance();
    }

   /* @BeforeMethod
    @Parameters(value = {"browser"})
    public synchronized  void initDriver(@Optional("Chrome") String browser, Method test)
    {
        ExtentTestManager.createTest(test.getName()+"_"+browser);
        ExtentTestManager.getTest().assignCategory(browser);
        setupDriver(browser);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }*/

    @BeforeMethod
    @Parameters(value = {"browser"})
    public synchronized  void initDriver(@Optional("Chrome") String browser, Method test)
    {
        ExtentTestManager.createTest(test.getName()+"_"+browser);
        ExtentTestManager.getTest().assignCategory(browser);
        BrowserManager.getInstance().setupDriver(browser);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public synchronized void closeDriver(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
            ExtentTestManager.getTest().fail(result.getThrowable());
        else if (result.getStatus() == ITestResult.SKIP)
            ExtentTestManager.getTest().skip(result.getThrowable());
        else
            ExtentTestManager.getTest().pass("Test passed");

        getDriver().close();
        getDriver().quit();
    }

    @AfterSuite
    public void finalizeExtendReports()
    {
        ExtentManager.getInstance().flush();
        ExtentManager.openExtentReport();
    }

    /*public void setupDriver(String browser)
    {
        System.out.println(browser);
        if(browser.equalsIgnoreCase("Chrome"))
        {
            WebDriverManager.chromedriver().setup();
            setDriver(new ChromeDriver());
        }
        else if(browser.equalsIgnoreCase("Edge"))
        {
            WebDriverManager.edgedriver().setup();
            setDriver(new EdgeDriver());
        }
        else
        {
            WebDriverManager.chromedriver().setup();
            setDriver(new ChromeDriver());
        }

    }*/

}
