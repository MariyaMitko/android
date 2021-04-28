package mitsko.mobile.automation.android.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class TelegramPage extends AbstractPage {
    
    private final String channelRoot = "//*[@package='org.telegram.messenger']";
    private final String joinBtnId = "//android.view.View[@content-desc='JOIN']";
    
	public TelegramPage(AndroidDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
    public boolean isTelegramChannelOpened(){
		
		MobileElement channelTitle = (MobileElement) driver.findElement(By.xpath(channelRoot));
		boolean isDisplayed = channelTitle.isDisplayed();
		
		return isDisplayed;
	}
		  
    public boolean isJoinBtnPresented(){
		
  		MobileElement btn = (MobileElement) driver.findElement(By.xpath(joinBtnId));
  		boolean isDisplayed = btn.isDisplayed();
  		
  		return isDisplayed;
  	}
          
}