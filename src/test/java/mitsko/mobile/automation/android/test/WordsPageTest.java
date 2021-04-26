package mitsko.mobile.automation.android.test;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.*;

import mitsko.mobile.automation.android.objects.TranslatedWord;
import mitsko.mobile.automation.android.pages.MainPage;
import mitsko.mobile.automation.android.pages.WordsPage;
import mitsko.mobile.automation.android.steps.Steps;

public class WordsPageTest {
	private Steps st;
	private MainPage mp;
	private WordsPage wp;
    
	@BeforeClass
    public void setUp() throws MalformedURLException {
    	
    	  st = new Steps();
          st.initDriver();
       	  mp = st.getMainPage();
          mp.openSavedWords();
          wp = st.getWordsPage();
    }
               
    @Test
    public void verifyAddButton() {

        boolean buttonState = wp.isAddWordBtnEnabled();
                
        Assert.assertEquals(buttonState, true, "Add new word button should be enabled");
    }
    
    @Test(dependsOnMethods={"verifyAddButton"})
    public void verifyAddTranslationModal() {
    	
    	wp.openTranslationModal();

        boolean modalPresense = wp.isTranslateWordModalDisplayed();
                
        Assert.assertEquals(modalPresense, true, "Add translation modal shpild be opened after click on Add btn");
    }
    
    @Test(dependsOnMethods={"verifyAddTranslationModal"})
    public void verifyTranslation() {
    	
    	TranslatedWord word = new TranslatedWord("Кот", "cat");
    	wp.addTranslation(word.getWord(), word.getTranslation());

    	TranslatedWord[] actualArr = wp.getSavedWords();
    	int size = actualArr.length;
                
        Assert.assertEquals(size, 1, "Word should be added");
        word.equals(actualArr[0]);
    }
    
    @Test(dependsOnMethods={"verifyTranslation"})
    public void verifyWordRemoving() {
    	
      	wp.deleteWord();
      	      	
      	boolean wordPresense = wp.isWordRowPresented();
         
        Assert.assertEquals(wordPresense, false, "Word shoild be deleted");
      
    }
        
    @AfterClass
    public void teardown() {
        st.closeDriver();
    }
}