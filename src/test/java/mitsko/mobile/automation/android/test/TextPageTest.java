package mitsko.mobile.automation.android.test;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.*;


import mitsko.mobile.automation.android.pages.BooksPage;
import mitsko.mobile.automation.android.pages.ChaptersPage;
import mitsko.mobile.automation.android.pages.MainPage;
import mitsko.mobile.automation.android.pages.TextPage;

import mitsko.mobile.automation.android.steps.Steps;

public class TextPageTest {
	private Steps st;
	private MainPage mp;
	private BooksPage bp;
	private ChaptersPage cp;
	private TextPage tp;
    
	@BeforeClass
    public void setUp() throws MalformedURLException {
    	
    	  st = new Steps();
          st.initDriver();
       	  mp = st.getMainPage();
          mp.openBooks();
          bp = st.getBooksPage();
          cp = st.geChaptersPage();
          tp = st.getTestPage();
    }
         
    @Test
    public void verifyChapters() {
        bp.openBook("Сборник простых английских текстов");
    	String[] actualArr = cp.readChapters();
                
        Assert.assertEquals(actualArr[0], " My Family", "Book should contain correct chapters");
   }
    
    @Test(dependsOnMethods={"verifyChapters"})
    public void verifyAdvancePage() {
    	cp.openChapter(" My Family");
    	boolean isDisplayed = tp.isAdvancePageDisplayed();
                
        Assert.assertEquals(isDisplayed, true, "Book should contain correct chapters");
   }
    
    @Test(dependsOnMethods={"verifyAdvancePage"})
    public void verifyOpenedBookTitle() {
    	tp.closeAdvancePage();
    	String title = tp.readTitle();
                
        Assert.assertEquals(title, "Сборник простых английских текстов, My Family", "Opened book should contain correct tilte");
   }
             
    @AfterClass
    public void teardown() {
        st.closeDriver();
    }
}