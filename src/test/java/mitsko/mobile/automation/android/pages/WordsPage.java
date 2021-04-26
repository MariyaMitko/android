package mitsko.mobile.automation.android.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import mitsko.mobile.automation.android.objects.Book;
import mitsko.mobile.automation.android.objects.TranslatedWord;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class WordsPage extends AbstractPage {
    private static final Logger logger =  LogManager.getRootLogger();
    
    private final String addBtnId                 = "com.kursx.smartbook:id/dictionary_add_button";
    private final String translateWordModalId     = "com.kursx.smartbook:id/linearLayout4";
    private final String wordInputId              = "com.kursx.smartbook:id/update_word_edit";
    private final String translationInputId       = "com.kursx.smartbook:id/update_item_edit";
    private final String dialogTranslationInputId = "com.kursx.smartbook:id/dialog_translation";
    private final String dialogTranslationBtnId   = "com.kursx.smartbook:id/dialog_translation_save";
    private final String translateBtnId           = "com.kursx.smartbook:id/update_save_button";
    private final String deleteBtnId              = "com.kursx.smartbook:id/update_delete_button";
    private final String confirmBtnId             = "com.kursx.smartbook:id/md_buttonDefaultPositive";
    private final String savedWordsSelector       = "//*[@resource-id='com.kursx.smartbook:id/dictionary_item_layout']";
    private final String wordsSelector            = "/*[@resource-id='com.kursx.smartbook:id/dictionary_view_item_first']";
    private final String translationSelector      = "//*[@resource-id='com.kursx.smartbook:id/dictionary_view_item_second']";
    
	public WordsPage(AndroidDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public boolean isAddWordBtnEnabled(){

		MobileElement addBtnElement = (MobileElement) driver.findElementById(addBtnId);
		boolean isEnabled = addBtnElement.isEnabled();
		return isEnabled;
	}
	
	public void openTranslationModal(){
		
		MobileElement addBtnElement = (MobileElement) driver.findElementById(addBtnId);
		
		addBtnElement.click();
	}
	
	public boolean isTranslateWordModalDisplayed(){

		MobileElement addBtnElement = (MobileElement) driver.findElementById(translateWordModalId);
		boolean isDisplayed = addBtnElement.isDisplayed();
		return isDisplayed;
	}
	
	public void addTranslation(String word, String translation){
		
		MobileElement wordInput = (MobileElement) driver.findElementById(wordInputId);
		MobileElement translationInput = (MobileElement) driver.findElementById(translationInputId);
			
		wordInput.sendKeys(word);		
		translationInput.click();
		
		MobileElement subWordInput = (MobileElement) driver.findElementById(dialogTranslationInputId);
		MobileElement subTranslationInput = (MobileElement) driver.findElementById(dialogTranslationBtnId);
		
		subWordInput.sendKeys(translation);		
		subTranslationInput.click();
		
		MobileElement translateBtn = (MobileElement) driver.findElementById(translateBtnId);
		
		translateBtn.click();
		
	}
	
    public TranslatedWord[] getSavedWords(){
		 	
	    List<MobileElement> words = driver.findElements(By.xpath(savedWordsSelector));
        int n = words.size();
	    TranslatedWord[] arr = new TranslatedWord[n];
	  
	    int i = 0;
	    for (MobileElement element : words) {
	    String word = element.findElement(By.xpath(wordsSelector)).getText();
	    String translation = element.findElement(By.xpath(translationSelector)).getText();

	    TranslatedWord w = new TranslatedWord(word, translation);

	    arr[i] = w;
	    }
	     	
		return arr;
    }
    
    public void deleteWord(){
		
        List<MobileElement> words = driver.findElements(By.xpath(savedWordsSelector));
        MobileElement wordRow = words.get(0);
    	  
        wordRow.click();
     	  
        MobileElement deleteBtn = (MobileElement) driver.findElementById(deleteBtnId);
       
        deleteBtn.click();
        
        MobileElement confirmBtn = (MobileElement) driver.findElementById(confirmBtnId);
        
        confirmBtn.click();
   	}
    
    public boolean isWordRowPresented() {
    	
    	 try {
    		  driver.findElement(By.xpath(savedWordsSelector));
    	        return true;
    	    } catch (org.openqa.selenium.NoSuchElementException e) {
    	        return false;
    	    }
    	    
    }
    
}