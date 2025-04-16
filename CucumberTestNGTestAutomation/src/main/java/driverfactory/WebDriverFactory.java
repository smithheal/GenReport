package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class WebDriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	private WebDriverFactory() {
		
	}

	public static void setDriver() {

		String browser = System.getProperty("browser", "edge");
		if (browser.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver());
			getDriver().manage().window().maximize();
			getDriver().manage().deleteAllCookies();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			getDriver().manage().window().maximize();
			getDriver().manage().deleteAllCookies();
		} else {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver.set(new ChromeDriver(options));
			getDriver().manage().window().maximize();
			getDriver().manage().deleteAllCookies();
		}
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void closeDriver() {
		driver.get().quit();
		driver.remove();
	}

}
