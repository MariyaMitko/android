package mitsko.mobile.automation.android.test;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.*;
import mitsko.mobile.automation.android.pages.MainPage;
import mitsko.mobile.automation.android.steps.Steps;

public class MainPageTest {
	private Steps st;
	private MainPage mp;
    
    @BeforeClass
    public void setUp() throws MalformedURLException {

       st = new Steps();
       st.initDriver();
       mp = st.getMainPage();
    }
    
    @Test
    public void verifyTitle() throws InterruptedException {

       String title = mp.readTitle();
                
       Assert.assertEquals(title, "Сборник простых английских текстов", "App titple should be correct");
   }
         
    @Test
    public void verifyPlayButton() throws InterruptedException {

       String title = mp.readTitle();
       boolean buttonState = mp.isPlayBtnEnabled();
                
       Assert.assertEquals(buttonState, true, "Play button should be enabled");
   }
    
    @Test
    public void verifyWidgets() {

       String title = mp.readTitle();
       String[] actualArr = mp.getAvailableWidgets();
       String[] excpetedArr = {"Мои книги", "Словарь", "Настройки", "Магазин", "Статистика", "Закладки"};

       Assert.assertEquals(excpetedArr, actualArr, "App should contains available widgets");
   }
    
     
    @AfterClass
    public void teardown() {
       st.closeDriver();
    }
}