package mitsko.mobile.automation.android.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
    
    private final String pageTitleId         = "com.kursx.smartbook:id/main_name";
    private final String playBtnId           = "com.kursx.smartbook:id/main_play";
    private final String widgetsRootSelector = "//*[@resource-id='com.kursx.smartbook:id/main_cover']/following-sibling::*[1]";
    private final String booksWidgetId       = "com.kursx.smartbook:id/main_bookshelf";
    private final String wordsWidgetId       = "com.kursx.smartbook:id/main_saved_words";
    private final String telegramBtnId       = "com.kursx.smartbook:id/main_ads_image";
    
	public MainPage(AndroidDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public String readTitle(){
		
		MobileElement pageTitleElement = (MobileElement) driver.findElementById(pageTitleId);
		String pageTitle = pageTitleElement.getText();
		
		return pageTitle;
	}
	
	public boolean isPlayBtnEnabled(){
		
		MobileElement playBtnElement = (MobileElement) driver.findElementById(playBtnId);
		boolean isEnabled = playBtnElement.isEnabled();
		
		return isEnabled;
	}
	
    public String[] getAvailableWidgets(){

    	MobileElement root = (MobileElement) driver.findElement(By.xpath(widgetsRootSelector));
    	
    	List<MobileElement> widgets = root.findElements(By.className("android.widget.TextView"));
    	int n = widgets.size();
    	
        String[] arr = new String[n];
        int i = 0;
        
        for (MobileElement element : widgets) {
            arr[i++] = element.getText();
        }
     	
		return arr;  
	}
    
    public void openBooks () {
    	
    	MobileElement booksBtn = (MobileElement) driver.findElementById(booksWidgetId);
    	booksBtn.click(); 	
    }
    
    public void openSavedWords () {
    	
    	MobileElement wordsBtn = (MobileElement) driver.findElementById(wordsWidgetId);
    	wordsBtn.click();    	
    }
    
    public void openTelegramChannel(){
    	
    	MobileElement telegramBtn = (MobileElement) driver.findElementById(telegramBtnId);
    	telegramBtn.click();    	
    }

}