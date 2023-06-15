import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class NotepadTest {
    private static WindowsDriver notepadSession = null;
    public static String getDate(){
        LocalDate date = LocalDate.now();
        return date.toString();
    }
    @BeforeTest
    public static  void setUp(){
        try{
            DesiredCapabilities capabilities = new  DesiredCapabilities();
            capabilities.setCapability("app","C:\\Windows\\System32\\notepad.exe");
            capabilities.setCapability("platformName","Windows");
            capabilities.setCapability("deviceName","WindowsPC");
            notepadSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            notepadSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
//    @AfterMethod
//    public void closeApp()
//    {
//        notepadSession.quit();
//        setUp();
//    }
//    @AfterSuite
//     public void treatDown()
//     {
//         notepadSession.quit();
//     }
    @Test(priority = 0, description = "test case-01, open notepad & click on help then about notepad & click ok")
    public  void checkAboutWindows()
    {

      notepadSession.findElement(By.name("File")).click();
      notepadSession.findElementByName("Page setup").click();
      notepadSession.findElementByName("OK").click();
      notepadSession.findElementByName("Edit").sendKeys("Hello, Etu SQA at Ibos!");
      notepadSession.findElementByName("Edit").clear();

    }
    @Test
    public void sendTestText(){
        notepadSession.findElementByName("Edit").sendKeys(getDate());
        notepadSession.findElementByName("Edit").clear();
    }
}
