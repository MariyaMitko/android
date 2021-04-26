package mitsko.mobile.automation.android.pages;

import io.appium.java_client.android.AndroidDriver;

public abstract class AbstractPage {
	
	protected AndroidDriver driver;

    public AbstractPage(AndroidDriver driver)
	{
		this.driver = driver;
	}
}