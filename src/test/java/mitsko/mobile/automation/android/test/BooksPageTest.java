package mitsko.mobile.automation.android.test;

import java.net.MalformedURLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import io.qameta.allure.Step;
import mitsko.mobile.automation.android.objects.Book;
import mitsko.mobile.automation.android.pages.BooksPage;
import mitsko.mobile.automation.android.pages.MainPage;
import mitsko.mobile.automation.android.steps.Steps;

public class BooksPageTest {
	
	private Steps st;
	private MainPage mp;
	private BooksPage bp;
	private static final Logger logger = LogManager.getRootLogger();
    
	@BeforeClass
    public void setUp() throws MalformedURLException {

       st = new Steps();
       st.initDriver();
       mp = st.getMainPage();
       mp.openBooks();
       bp = st.getBooksPage();
       logger.info("== WHEN app's Books page is opened ==");
    }
         
    @Test
    @Step("Verify Download button is enabled")
    public void isDownloadButtonEnabled() {

       logger.info("== THEN Download button is enabled ==");          
       Assert.assertEquals(bp.isDownloadBooksBtnEnabled(), true);
    }
    
    @Test(dependsOnMethods={"isDownloadButtonEnabled"})
    @Step("Verify books list")
    public void checkAvailableBooks() {

       Book b = new Book("Сборник простых английских текстов", "Smart Book");
       Book[] actualArr = bp.getAvailableBooks();

       logger.info("== THEN books list contains corresct book ==");    
       b.equals(actualArr[0]);
    }
    
    @Test(dependsOnMethods={"checkAvailableBooks"})
    @Step("Verify Browser url")
    public void checkUrl() {
    	
       logger.info("== WHEN user clicks on 'Скачать больше книг' ==");    
       String actualArr = bp.clickDownloadAndVerify();
       
       logger.info("== THEN user should be redirected on correct browser page ==");    
       Assert.assertTrue(actualArr.contains("smart-book.net"));

    }
    
    @AfterClass
    public void teardown() {
        st.closeDriver();
    }
}