package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(name="user-name")
	WebElement untxtbx;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="login-button")
	WebElement loginBtn;
	
public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	
}
public void loginFunction(String userNameVal,String passwordVal) {
	untxtbx.sendKeys(userNameVal);
	password.sendKeys(passwordVal);
	loginBtn.click();	
}

}
