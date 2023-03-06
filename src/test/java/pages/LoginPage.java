package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Page Factory
	
	//@FindBy
	
	@FindBy(xpath="//input[@name='username']")
	public WebElement usernameTextBox;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement passwordTextBox;
	
	@FindBy(xpath="//input[@name='login']")
	public WebElement loginButton;
	
	 @FindBy(xpath = "//a[text()='New User Register Here']")
	 public WebElement registerLink;
		
	@FindBy(xpath = "//a[text()='Forgot Password?']")
	public WebElement forgotPasswordLink;
	
	
	

}
