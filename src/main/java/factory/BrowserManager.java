package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserManager {
    private BrowserManager()
    {
    }
    private static BrowserManager instance= new BrowserManager();

    public DesiredCapabilities cap =new DesiredCapabilities();
    static BrowserManager getInstance()
    {
        return instance;
    }
    public void setupDriver(String browser,String runOnMachine) {
        System.out.println(browser);
        try {
            if (browser.equalsIgnoreCase("Chrome")) {
                if (runOnMachine.equalsIgnoreCase("Grid")) {
                    cap.setPlatform(Platform.ANY);
                    cap.setBrowserName("chrome");
                    ChromeOptions coptions = new ChromeOptions();
                    coptions.merge(cap);
                    DriverManager.getInstance().setDriver(new RemoteWebDriver(new URL("http://192.168.1.7:4444"), cap));
                } else {
                    WebDriverManager.chromedriver().setup();
                    DriverManager.getInstance().setDriver(new ChromeDriver());
                }
            } else if (browser.equalsIgnoreCase("Edge")) {
                if (runOnMachine.equalsIgnoreCase("Grid")) {
                    cap.setPlatform(Platform.ANY);
                    cap.setBrowserName("MicrosoftEdge");
                    EdgeOptions eoptions = new EdgeOptions();
                    eoptions.merge(cap);
                    DriverManager.getInstance().setDriver(new RemoteWebDriver(new URL("http://192.168.1.7:4444"), cap));
                } else {
                    WebDriverManager.edgedriver().setup();
                    DriverManager.getInstance().setDriver(new EdgeDriver());
                }
            } else if (browser.equalsIgnoreCase("FireFox")) {
                WebDriverManager.firefoxdriver().setup();
                DriverManager.getInstance().setDriver(new FirefoxDriver());
            } else if (browser.equalsIgnoreCase("IE")) {
                WebDriverManager.iedriver().setup();
                DriverManager.getInstance().setDriver(new InternetExplorerDriver());
            } else {
                WebDriverManager.chromedriver().setup();
                DriverManager.getInstance().setDriver(new ChromeDriver());
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
}
