package mitsko.mobile.automation.android.test;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.*;


import mitsko.mobile.automation.android.pages.BooksPage;
import mitsko.mobile.automation.android.pages.ChaptersPage;
import mitsko.mobile.automation.android.pages.MainPage;
import mitsko.mobile.automation.android.pages.TelegramPage;
import mitsko.mobile.automation.android.pages.TextPage;

import mitsko.mobile.automation.android.steps.Steps;

public class TelegramPageTest {
	private Steps st;
	private MainPage mp;
	private TelegramPage tp;
    
	@BeforeClass
    public void setUp() throws MalformedURLException {
    	
    	  st = new Steps();
          st.initDriver();
       	  mp = st.getMainPage();
       	  tp = st.getTelegramPage();
          
    }
         
    @Test
    public void verifyChannelOpened() {
        mp.openTelegramChannel();
    	boolean isDisplayed = tp.isTelegramChannelOpened();
                
        Assert.assertEquals(isDisplayed, true, "Book should contain correct chapters");
   }
    
    @Test(dependsOnMethods={"verifyChannelOpened"})
    public void verifyChannelTitle() {
  
    	boolean isDisplayed = tp.isJoinBtnPresented();
        
        Assert.assertEquals(isDisplayed, true, "Book should contain correct chapters");
   }
                  
    @AfterClass
    public void teardown() {
        st.closeDriver();
    }
}