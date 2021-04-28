package mitsko.mobile.automation.android.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class ChaptersPage extends AbstractPage {
    
    private final String chaptersSelector = "//*[@resource-id='com.kursx.smartbook:id/chapter_item_title']";
    
	public ChaptersPage(AndroidDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
		  
    public String[] readChapters(){

    	List<MobileElement> books = driver.findElements(By.xpath(chaptersSelector));
    	int n = books.size();

		String[] arr = new String[n];
		int i = 0;
		
	        for (MobileElement element : books) {
	            arr[i++] = element.getText();
	        }
	        
		return arr;
	}
    
    public void openChapter(String title){
    	
    	String xpath = "//*[@text='" + title + "']";

    	MobileElement element = (MobileElement) driver.findElement(By.xpath(xpath));
    	
    	element.click();
    }
    
}