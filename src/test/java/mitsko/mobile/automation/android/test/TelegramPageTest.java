package mitsko.mobile.automation.android.test;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import io.qameta.allure.Step;
import mitsko.mobile.automation.android.pages.MainPage;
import mitsko.mobile.automation.android.pages.TelegramPage;
import mitsko.mobile.automation.android.steps.Steps;

public class TelegramPageTest {
	
	private Steps st;
	private MainPage mp;
	private TelegramPage tp;
	private static final Logger logger = LogManager.getRootLogger();
	
	@BeforeClass
    public void setUp() throws MalformedURLException {
    	
        st = new Steps();
        st.initDriver();
        mp = st.getMainPage();
        tp = st.getTelegramPage();
        logger.info("== WHEN app's Main page is opened ==");
          
    }
         
    @Test
    @Step("Verify Telegram channel")
    public void verifyChannelOpened() {
    	
    	logger.info("== AND user click on Telegram icon ==");
        mp.openTelegramChannel();
                
        logger.info("== THEN channel is opened ==");
        Assert.assertEquals(tp.isTelegramChannelOpened(), true);
    }
    
    @Test(dependsOnMethods={"verifyChannelOpened"})
    @Step("Verify Join button")
    public void verifyJoinBtn() {
  
    	logger.info("== THEN Join button is enabled ==");
        Assert.assertEquals(tp.isJoinBtnPresented(), true);
    }
                  
    @AfterClass
    public void teardown() {
        st.closeDriver();
    }
}