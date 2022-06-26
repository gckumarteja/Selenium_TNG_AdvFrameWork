package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserManager {
    private BrowserManager()
    {
    }
    private static BrowserManager instance= new BrowserManager();

    static BrowserManager getInstance()
    {
        return instance;
    }
    public void setupDriver(String browser)
    {
        System.out.println(browser);
        if(browser.equalsIgnoreCase("Chrome"))
        {
            WebDriverManager.chromedriver().setup();
            DriverManager.getInstance().setDriver(new ChromeDriver());
        }
        else if(browser.equalsIgnoreCase("Edge"))
        {
            WebDriverManager.edgedriver().setup();
            DriverManager.getInstance().setDriver(new EdgeDriver());
        }
        else if(browser.equalsIgnoreCase("FireFox"))
        {
            WebDriverManager.firefoxdriver().setup();
            DriverManager.getInstance().setDriver(new FirefoxDriver());
        }
        else if(browser.equalsIgnoreCase("IE"))
        {
            WebDriverManager.iedriver().setup();
            DriverManager.getInstance().setDriver(new InternetExplorerDriver());
        }
        else {
            WebDriverManager.chromedriver().setup();
            DriverManager.getInstance().setDriver(new ChromeDriver());
        }

    }
}
