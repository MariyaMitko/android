package mitsko.mobile.automation.android.test;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import io.qameta.allure.Step;
import mitsko.mobile.automation.android.pages.MainPage;
import mitsko.mobile.automation.android.steps.Helper;
import mitsko.mobile.automation.android.steps.Steps;

public class MainPageTest {
	
	private Steps st;
	private MainPage mp;
	private Helper hp;
	private static final Logger logger = LogManager.getRootLogger();
    
    @BeforeClass
    public void setUp() throws MalformedURLException {

       st = new Steps();
       hp = new Helper();
       st.initDriver();
       mp = st.getMainPage();
       logger.info("== WHEN app's Main page is opened ==");
    }
    
    @Test
    @Step("Verify main page contains correct title")
    public void verifyTitle() {
    	
       logger.info("== THEN page contains correct title ==");
       Assert.assertEquals(mp.readTitle(), hp.getExpectedTitle());
   }
         
    @Test
    @Step("Verify Play button is enabled")
    public void verifyPlayButton() {

       logger.info("== THEN Play button is enabled ==");
       Assert.assertEquals(mp.isPlayBtnEnabled(), true);
   }
    
    @Test
    @Step("Verify main page contains 6 available widgets")
    public void verifyWidgets() {

       String[] actualArr = mp.getAvailableWidgets();
       String[] excpetedArr = hp.getExpectedWidgets();

       logger.info("== THEN page contains 6 available widgets ==");
       Assert.assertEquals(excpetedArr, actualArr);
   }
    
     
    @AfterClass
    public void teardown() {
       st.closeDriver();
    }
}