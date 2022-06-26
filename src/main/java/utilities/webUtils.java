package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;

public class webUtils {


    public static String captureScreenShot(WebDriver driver)
    {
        String imgBase64 = null;
        try
        {
            imgBase64=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        }
        catch (Exception ex)
        {
            System.out.println("Screenshot Issue: "+ex);
        }
        return  "<a href=data:image/gif;base64," + imgBase64 + " data-featherlight=\"image\">\n" +
                "<img src=data:image/gif;base64," + imgBase64 + " width=\"100\" height=\"50\" alt=\"base64 test\">\n" +
                "</a>";
    }

//    public synchronized static String captureScreenShot(WebDriver driver)
//    {
//        String imgBase64=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
//
////        Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
////        ImageIO.write(screenshot.getImage(),"PNG",new File("path of the file"));
//
//        return  "<a href=data:image/gif;base64," + imgBase64 + " data-featherlight=\"image\">\n" +
//                "<img src=data:image/gif;base64," + imgBase64 + " width=\"100\" height=\"50\" alt=\"base64 test\">\n" +
//                "</a>";
//        //return "data:image/png;base64," +imgBase64;
//       // return "<img class=\"col-lg-12\" src=data:image/png;base64," + imgBase64 + " width=\"100\" height=\"50\" alt=\"base64 test\">";
//      //  return imgBase64;
//    }


}
