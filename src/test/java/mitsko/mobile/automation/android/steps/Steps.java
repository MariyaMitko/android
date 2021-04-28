package mitsko.mobile.automation.android.steps;

import java.net.MalformedURLException;
import mitsko.mobile.automation.android.pages.BooksPage;
import mitsko.mobile.automation.android.pages.ChaptersPage;
import mitsko.mobile.automation.android.pages.MainPage;
import mitsko.mobile.automation.android.pages.TelegramPage;
import mitsko.mobile.automation.android.pages.TextPage;
import mitsko.mobile.automation.android.pages.WordsPage;
import io.appium.java_client.android.AndroidDriver;
import mitsko.mobile.automation.android.driver.MobileDriver;

public class Steps {
	
	private AndroidDriver driver;

	public void initDriver() throws MalformedURLException {
		driver = MobileDriver.getDriver();
	}

		
	public void closeDriver(){
		MobileDriver.closeDriver();
	}
	
	public MainPage getMainPage()
	{
		MainPage page = new MainPage(driver);
		return page;
	}
	
	public BooksPage getBooksPage()
	{
		BooksPage page = new BooksPage(driver);
		return page;
	}
	
	public WordsPage getWordsPage()
	{
		WordsPage page = new WordsPage(driver);
		return page;
	}
	
	public ChaptersPage geChaptersPage()
	{
		ChaptersPage page = new ChaptersPage(driver);
		return page;
	}
	
	public TextPage getTestPage()
	{
		TextPage page = new TextPage(driver);
		return page;
	}
	
	public TelegramPage getTelegramPage()
	{
		TelegramPage page = new TelegramPage(driver);
		return page;
	}

}
