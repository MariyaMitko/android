package mitsko.mobile.automation.android;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorTest {
    private AndroidDriver driver;

    
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
       
        capabilities.setCapability("deviceName", "Xperia");
       
        capabilities.setCapability("platformName", "Android");
       
        capabilities.setCapability("platformVersion", "8.0");
       
        capabilities.setCapability("udid", "CB512DW9X5");
        
        capabilities.setCapability("appPackage", "com.google.android.calculator");
      
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        
        capabilities.setCapability("ignoreHiddenApiPolicyError", true);
        
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }
    
    @Test
    public void testAddition() {
        MobileElement buttonTwo = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        buttonTwo.click();
        
        driver.findElementById("com.google.android.calculator:id/op_add").click();
        
        driver.findElementById("com.google.android.calculator:id/digit_3").click();
        
        MobileElement results = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_preview");
        
        Assert.assertEquals("5", results.getText(), "Result should be equals 5");
    }
    
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
