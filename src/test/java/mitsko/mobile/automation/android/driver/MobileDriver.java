package mitsko.mobile.automation.android.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;



public class MobileDriver {
	    
     	private static AndroidDriver driver;
	
	    private static final Logger logger =  LogManager.getRootLogger();

	    
	    private MobileDriver(){
	    	
	    };


	    public static AndroidDriver getDriver() throws MalformedURLException {
	        if (null == driver){
	        	 DesiredCapabilities capabilities = new DesiredCapabilities();
	             
	             capabilities.setCapability("deviceName", "Xperia");
	            
	             capabilities.setCapability("platformName", "Android");
	            
	             capabilities.setCapability("platformVersion", "8.0");
	            
	             capabilities.setCapability("udid", "CB512DW9X5");
	             
	             capabilities.setCapability("appPackage", "com.kursx.smartbook");
	           
	             capabilities.setCapability("appActivity", "com.kursx.smartbook.ui.main.MainActivity");
	             
	             capabilities.setCapability("ignoreHiddenApiPolicyError", true);
	             
	             driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
	             
	             driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	             
	             logger.info("Browser started");
	        }

	        return driver;
	    }

	    public static void closeDriver(){
	        driver.quit();
	        driver = null;
	    }
	}