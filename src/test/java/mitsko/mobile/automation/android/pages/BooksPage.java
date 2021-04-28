package mitsko.mobile.automation.android.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import mitsko.mobile.automation.android.objects.Book;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class BooksPage extends AbstractPage {
    
    private final String downloadBtnId       = "com.kursx.smartbook:id/activity_books_button_name";
    private final String booksRowsSelector   = "//*[@resource-id='com.kursx.smartbook:id/book_item_card']";
    private final String booksTitleSelector  = "//*[@resource-id='com.kursx.smartbook:id/book_item_ru_name']";
    private final String booksAuthorSelector = "//*[@resource-id='com.kursx.smartbook:id/book_item_author']";
    private final String nativeAppUrl        = "com.android.chrome:id/url_bar";
    
	public BooksPage(AndroidDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public boolean isDownloadBooksBtnEnabled(){

		MobileElement downloadBtnElement = (MobileElement) driver.findElementById(downloadBtnId);
		boolean isEnabled = downloadBtnElement.isEnabled();
		
		return isEnabled;
	}
	
    public Book[] getAvailableBooks(){
 	
    	List<MobileElement> books = driver.findElements(By.xpath(booksRowsSelector));

        Book[] arr = new Book[6];
  
        int i = 0;
        for (i = 0; i <= 5; i=i+1) {
           String title = books.get(i).findElement(By.xpath(booksTitleSelector)).getText();
           String author = books.get(i).findElement(By.xpath(booksAuthorSelector)).getText();

           Book b = new Book(title, author);

           arr[i] = b;
        }
     	
		return arr;
  	}
    
    public String clickDownloadAndVerify(){
    	
    	MobileElement downloadBtnElement = (MobileElement) driver.findElementById(downloadBtnId);
    	downloadBtnElement.click();

    	MobileElement url = (MobileElement) driver.findElementById(nativeAppUrl);
    	String address = url.getText();
    	
		return address;    
    }
    
    public void openBook(String title){
    	
    	String xpath = "//*[@text='" + title + "']";

    	MobileElement element = (MobileElement) driver.findElement(By.xpath(xpath));
    	
    	element.click();
    }    
  
}