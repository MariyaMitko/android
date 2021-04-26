package mitsko.mobile.automation.android.test;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.*;

import mitsko.mobile.automation.android.objects.Book;
import mitsko.mobile.automation.android.pages.BooksPage;
import mitsko.mobile.automation.android.pages.MainPage;
import mitsko.mobile.automation.android.steps.Steps;

public class BooksPageTest {
	private Steps st;
	private MainPage mp;
	private BooksPage bp;
    
	@BeforeClass
    public void setUp() throws MalformedURLException {

    	  st = new Steps();
          st.initDriver();
       	  mp = st.getMainPage();
          mp.openBooks();
          bp = st.getBooksPage();
    }
         
    @Test
    public void isDownloadButtonEnabled() throws InterruptedException {

       boolean buttonState = bp.isDownloadBooksBtnEnabled();
                
       Assert.assertEquals(buttonState, true, "Download button should be enabled");
   }
    
    @Test(dependsOnMethods={"isDownloadButtonEnabled"})
    public void checkAvailableBooks() {

       Book b = new Book("Сборник простых английских текстов", "Smart Book");
       Book[] actualArr = bp.getAvailableBooks();

       b.equals(actualArr[0]);
   }
    
    @Test(dependsOnMethods={"checkAvailableBooks"})
    public void checkUrl() throws InterruptedException {

       String actualArr = bp.clickDownloadAndVerify();
       Assert.assertTrue(actualArr.contains("smart-book.net"), "User should be redirected on web app page");

   }
    
    @AfterClass
    public void teardown() {
        st.closeDriver();
    }
}