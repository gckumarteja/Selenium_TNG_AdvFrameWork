package Appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SampleCalc {

public static void main(String args[])
{
    DesiredCapabilities cap= new DesiredCapabilities();
    cap.setCapability("appium:deviceName", "emulator-5554");
    cap.setCapability("platformName", "Android");
    cap.setCapability("appium:platformVersion", "9");
    cap.setCapability("appium:appPackage", "com.android.calculator2");
    cap.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
    cap.setCapability("appium:ensureWebviewsHavePages", true);
    cap.setCapability("appium:nativeWebScreenshot", true);
    cap.setCapability("appium:newCommandTimeout", 3600);
    cap.setCapability("appium:connectHardwareKeyboard", true);

    //Instantiate Appium Driver
    try {
        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.calculator2:id/digit_6']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.calculator2:id/op_add']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.calculator2:id/digit_8']")).click();

        Thread.sleep(500);
       WebElement el= driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.android.calculator2:id/result']"));
       System.out.println(el.getAttribute("text"));
       Thread.sleep(2000);
        driver.quit();

    } catch (MalformedURLException | InterruptedException e) {
        System.out.println(e.getMessage());
    }


}
}
