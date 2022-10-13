package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {

	
	//By EMAIL = By.name("login[email]");
	//By PASSWORD = By.name("login[password]");
	//By LOGIN_BTN = By.xpath("//button[@type='submit' and text()='Login ']");
	

	
	@FindBy(name = "login[email]")
	WebElement txt_email;
	
	@FindBy(name = "login[password]")
	WebElement txt_password;
	
	
	@FindBy(xpath = "//button[@type='submit' and text()='Login ']")
	WebElement loginBtn;
	
	//Initialize  all page objects for given driver instances
	public LoginPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void doLogin(String emailId,String pwd) {
		txt_email.sendKeys(emailId);
		txt_password.sendKeys(pwd);
		loginBtn.click();
	}
	
}
