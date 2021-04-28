package mitsko.mobile.automation.android.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class TextPage extends AbstractPage {
    
    private final String advancePage         = "//*[@text='Текст, на языке оригинала']";
    private final String closeIconSelector   = "android.widget.ImageView";
    private final String toolbarSelector     = "//*[@resource-id='com.kursx.smartbook:id/reader_toolbar']";
    private final String titleTextClass      = "android.widget.TextView";
    
	public TextPage(AndroidDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public boolean isAdvancePageDisplayed(){

		MobileElement downloadBtnElement = (MobileElement) driver.findElement(By.xpath(advancePage));
		
		boolean isEnabled = downloadBtnElement.isDisplayed();
		
		return isEnabled;
	}
	
	public void closeAdvancePage(){
		
		MobileElement closeIcon = (MobileElement) driver.findElementByClassName(closeIconSelector);
		
		closeIcon.click();
	}
	
	public String readTitle(){
		
		MobileElement toolbar = (MobileElement) driver.findElement(By.xpath(toolbarSelector));
		List<MobileElement> titles = (List<MobileElement>) toolbar.findElementsByClassName(titleTextClass);
		
		String bookName = titles.get(0).getText();
		String chapterName = titles.get(1).getText();
		
		String title = bookName + "," + chapterName;
		
		return title;
		
	}
	
      
}