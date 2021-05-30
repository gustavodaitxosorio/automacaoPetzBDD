package core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import core.Propriedades;

public class DriverFactory {
	
	private static WebDriver driver;
	private DriverFactory() {}
	
	public static WebDriver getDriver(){
		if(driver ==null){
		switch (Propriedades.browser) {
		case FIREFOX: System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		break;
		case CHROME:System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
					ChromeOptions ops = new ChromeOptions();
        			ops.addArguments("--disable-notifications");
        			ops.addArguments("--disable-popup-blocking");
		driver = new ChromeDriver(ops);
		driver.manage().window().setSize(new Dimension(1250, 1050));	
		break;
		}}
		
		return driver;
	}

	public static void killDriver(){
		WebDriver driver = getDriver();
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}

