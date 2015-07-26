package gargiCucumberproject.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ShareDriver extends EventFiringWebDriver {
	
	private static final 	WebDriver 	REAL_DRIVER;
	private static final Thread CLOSE_THREAD = new Thread() {
		@Override
		public void run() { 
			REAL_DRIVER.quit();
		}
	};
	
	static {
		REAL_DRIVER = new FirefoxDriver();
		REAL_DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
	}
	

	public ShareDriver() {
		super(REAL_DRIVER);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void close() {
		if (Thread.currentThread() != CLOSE_THREAD) {
			throw new UnsupportedOperationException(
					"You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
		}
		super.close();
	}
	
	@Before
	
	public void deleteAllCookies(){
		manage().deleteAllCookies();
		
	}
	
	@After
	public void embedScreenshot(Scenario scenario) {
		scenario.write("Current Page URL is " + getCurrentUrl());
		try {
			byte[] screenshot = getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		} catch (WebDriverException somePlatformsDontSupportScreenshots) {
			System.err
					.println(somePlatformsDontSupportScreenshots.getMessage());
		}
	}
	
	

}
