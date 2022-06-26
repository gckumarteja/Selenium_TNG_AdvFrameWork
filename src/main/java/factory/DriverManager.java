package factory;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private DriverManager()
    {
    }
    private static DriverManager instance= new DriverManager();

    public static DriverManager getInstance()
    {
        return instance;
    }
   private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public WebDriver getDriver()
    {
        return driver.get();
    }

    public void setDriver(WebDriver driverObj)
    {
        driver.set(driverObj);
    }

}
