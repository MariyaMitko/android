package mitsko.mobile.automation.android.test;

import java.net.MalformedURLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import io.qameta.allure.Step;
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
	private static final Logger logger = LogManager.getRootLogger();
    
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
    @Step("Verify books chapter")
    public void verifyChapters() {
    	
    	logger.info("== WHEN book is opened ==");
        bp.openBook("Сборник простых английских текстов");
    	String[] actualArr = cp.readChapters();
    	
    	logger.info("== THEN book contain correct chapters ==");         
        Assert.assertEquals(actualArr[0], " My Family");
    }
    
    @Test(dependsOnMethods={"verifyChapters"})
    @Step("Verify opened books advance page")
    public void verifyAdvancePage() {
    	
    	logger.info("== WHEN chapter is opened ==");
    	cp.openChapter(" My Family");
    	
    	logger.info("== THEN advance page is displayed ==");                 
        Assert.assertEquals(tp.isAdvancePageDisplayed(), true);
    }
    
    @Test(dependsOnMethods={"verifyAdvancePage"})
    @Step("Verify opened books title")
    public void verifyOpenedBookTitle() {
    	
    	logger.info("== WHEN advance page is closed ==");
    	tp.closeAdvancePage();
        
    	logger.info("== WTHEN opened book contains correct title ==");
        Assert.assertEquals(tp.readTitle(), "Сборник простых английских текстов, My Family");
    }
              
    @AfterClass
    public void teardown() {
        st.closeDriver();
    }
}