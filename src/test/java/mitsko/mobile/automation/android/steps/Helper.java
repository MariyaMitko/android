package mitsko.mobile.automation.android.steps;

public class Helper {
	
	public String[] getExpectedWidgets(){
		
		String[] arr = {"Мои книги", "Словарь", "Настройки", "Магазин", "Статистика", "Закладки"};
		return arr;
	}
	
    public String getExpectedTitle(){
		
		String title = "Сборник простых английских текстов";
		return title;
	}
}