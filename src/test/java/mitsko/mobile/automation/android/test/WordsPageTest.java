package mitsko.mobile.automation.android.test;

import java.net.MalformedURLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import io.qameta.allure.Step;
import mitsko.mobile.automation.android.objects.TranslatedWord;
import mitsko.mobile.automation.android.pages.MainPage;
import mitsko.mobile.automation.android.pages.WordsPage;
import mitsko.mobile.automation.android.steps.Steps;

public class WordsPageTest {
	
	private Steps st;
	private MainPage mp;
	private WordsPage wp;
	private static final Logger logger = LogManager.getRootLogger();
    
	@BeforeClass
    public void setUp() throws MalformedURLException {
    	
    	st = new Steps();
        st.initDriver();
       	mp = st.getMainPage();
        mp.openSavedWords();
        wp = st.getWordsPage();
        logger.info("== WHEN user open Saved Words page ==");
    }
               
    @Test
    @Step("Verify 'Add new' button")
    public void verifyAddButton() {

        logger.info("== THEN button 'Add new' is enabled ==");        
        Assert.assertEquals(wp.isAddWordBtnEnabled(), true);
    }
    
    @Test(dependsOnMethods={"verifyAddButton"})
    @Step("Verify translation modal")
    public void verifyAddTranslationModal() {
    	
    	logger.info("== WHEN user click 'Add new' ==");
    	wp.openTranslationModal();

    	logger.info("== THEN translation modal is opened ==");          
        Assert.assertEquals(wp.isTranslateWordModalDisplayed(), true);
    }
    
    @Test(dependsOnMethods={"verifyAddTranslationModal"})
    @Step("Verify translated and saved word")
    public void verifyTranslation() {
    	
    	logger.info("== WHEN user add word translation ==");
    	TranslatedWord word = new TranslatedWord("Кот", "cat");
    	
    	wp.addTranslation(word.getWord(), word.getTranslation());
    	TranslatedWord[] actualArr = wp.getSavedWords();
    	
    	logger.info("== THEN translation is saved ==");         
        Assert.assertEquals(actualArr.length, 1);
        word.equals(actualArr[0]);
    }
    
    @Test(dependsOnMethods={"verifyTranslation"})
    @Step("Verify user can remove saved word")
    public void verifyWordRemoving() {
    	
    	logger.info("== WHEN user click word row ==");
    	logger.info("== AND select 'Remove' ==");
      	wp.deleteWord();
      	      	
      	logger.info("== THEN word is removed ==");   
        Assert.assertEquals(wp.isWordRowPresented(), false);
      
    }
        
    @AfterClass
    public void teardown() {
        st.closeDriver();
    }
}