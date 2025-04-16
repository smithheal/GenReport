package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import driverfactory.WebDriverFactory;

public class LoginPageFactory {

	public WebDriver driver;

	public LoginPageFactory() {
		//this.driver = driver;
		driver = WebDriverFactory.getDriver();
	}
	
	private static final By txtBoxUsername = By.xpath("//input[@name='username']");
	private static final By txtBoxPassword = By.xpath("//input[@name='password']");
	private static final By btnLogin = By.xpath("//button[@type='submit']");

	// Username locator
	@FindBy(xpath = "//input[@name='username']")
	public WebElement userName;

	// Password locator
	@FindBy(xpath = "//input[@name='password']")
	public WebElement passWord;

	// Login button locator
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginButton;

	// Forgot password locator
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	public WebElement forgotPassword;
	

	// Method that performs Username action
	public void enterUsername(String uname) {
		//userName.sendKeys(uname);
		driver.findElement(txtBoxUsername).sendKeys(uname);
	}

	// Method that performs Password action
	public void enterPassword(String pwd) {
		//passWord.sendKeys(pwd);
		driver.findElement(txtBoxPassword).sendKeys(pwd);
	}

	// Method that performs Login action
	public void clickLogin() {
		//loginButton.click();
		driver.findElement(btnLogin).click();
	}

	// Method that performs Forgot Password link verification
	public boolean isForgotPasswordLinkPresent() {
		return forgotPassword.isDisplayed();
	}

}
