package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//scripted by Shiva
public class SearchHotelPage  {

	WebDriver driver;
	
	public SearchHotelPage(WebDriver driver) { 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='location']")
	public WebElement loc;

	@FindBy(xpath = "//select[@id='hotels']")
	public WebElement hotels;

	@FindBy(xpath = "//select[@id='room_type']")
	public WebElement roomtype;

	@FindBy(xpath = "//select[@id='room_nos']")
	public WebElement numofrooms;

	@FindBy(xpath = "//input[@id='datepick_in']")
	public WebElement indate;

	@FindBy(xpath = "//input[@id='datepick_out']")
	public WebElement outdate;

	@FindBy(xpath = "//select[@id='adult_room']")
	public WebElement adultroom;

	@FindBy(xpath = "//select[@id='child_room']")
	public WebElement childrenroom;

	@FindBy(xpath = "//input[@id='Submit']")
	public WebElement searchbutton;
	
	@FindBy(xpath = "//input[@id='Reset']")
	public WebElement resetbutton;
	
	@FindBy(xpath = "//span[@id='checkin_span']")
	public WebElement checkInDateError;
	
	@FindBy(xpath = "//span[@id='checkout_span']")
	public WebElement checkOutDateError;

		
	
	
	
	
	
	
	
	
	
	
	
	

}