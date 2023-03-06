package steps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.SearchHotelPage;

public class StepDefinitions {
	
	
	
	FileInputStream fis1;
	Properties configProp=new Properties();;
	
	public WebDriver driver;
	
	LoginPage loginPage;
	SearchHotelPage searchHotelPage;

	//hooks
	@Before
	public void setUp()
	{
		
		try {
			fis1=new FileInputStream("src\\test\\resources\\properties\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			configProp.load(fis1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(configProp.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			}
		else if(configProp.getProperty("browser").equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			}
		
		else if(configProp.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			}
		
		//to launch appp
		
		driver.get(configProp.getProperty("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("implicitWait"))));
		
	}
	
	
	//After hook
	
	@After
	public void teardown()
	{
		driver.quit();
	}
	
	@Given("user is on LoginPage")
	public void user_is_on_login_page() {
		// Write code here that turns the phrase above into concrete actions

		 loginPage=new LoginPage(driver);
	}

	@When("user enters text in textbox in LoginPage")
	public void user_enters_text_in_textbox_in_login_page(DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		
		
		List<Map<String, String>> listOfMaps=dataTable.asMaps();
		
		System.out.println("listOfMaps.size() "+listOfMaps.size());
		
		System.out.println(listOfMaps.get(0).get("objectName"));
		System.out.println(listOfMaps.get(0).get("text"));
		
		if(listOfMaps.get(0).get("objectName").equals("usernameTextBox"))
		loginPage.usernameTextBox.sendKeys(listOfMaps.get(0).get("text"));
		else if(listOfMaps.get(0).get("objectName").equals("passwordTextBox"))
			loginPage.passwordTextBox.sendKeys(listOfMaps.get(0).get("text"));
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@When("user clicks on Button in LoginPage")
	public void user_clicks_on_button_in_login_page(DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.

		List<Map<String, String>> listOfMaps=dataTable.asMaps();
		
		System.out.println("listOfMaps.size() "+listOfMaps.size());
		
		System.out.println(listOfMaps.get(0).get("objectName"));
		
		loginPage.loginButton.click();
	}

	@Then("user validates title to be {string}")
	public void user_validates_title_to_be(String expTitle)  {
		// Write code here that turns the phrase above into concrete actions

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(driver.getTitle(), expTitle);
	}

	@Given("user is on SearchHotelPage")
	public void user_is_on_search_hotel_page() {
	    
		searchHotelPage=new SearchHotelPage(driver);
	}
	
	@When("user enters details in SearchHotelPage")
	public void user_enters_details_in_search_hotel_page(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	   
		List<Map<String, String>> listOfMaps=dataTable.asMaps();
		
		new Select(searchHotelPage.loc).selectByVisibleText(listOfMaps.get(0).get("Location"));
		new Select(searchHotelPage.hotels).selectByVisibleText(listOfMaps.get(0).get("Hotels"));
		new Select(searchHotelPage.roomtype).selectByVisibleText(listOfMaps.get(0).get("Room Type"));
		new Select(searchHotelPage.numofrooms).selectByVisibleText(listOfMaps.get(0).get("Number of Rooms"));
		searchHotelPage.indate.clear();
		searchHotelPage.indate.sendKeys(listOfMaps.get(0).get("Check InDate"));
		searchHotelPage.outdate.clear();
		searchHotelPage.outdate.sendKeys(listOfMaps.get(0).get("Check OutDate"));
		new Select(searchHotelPage.adultroom).selectByVisibleText(listOfMaps.get(0).get("Adults per Room"));
		new Select(searchHotelPage.childrenroom).selectByVisibleText(listOfMaps.get(0).get("Kids per room"));
		
		
	}
	
	@When("user clicks on Button in SearchHotelPage")
	public void user_clicks_on_button_in_search_hotel_page(DataTable dataTable) {
	    
		List<Map<String, String>> listOfMaps=dataTable.asMaps();
		
		System.out.println("listOfMaps.size() "+listOfMaps.size());
		
		System.out.println(listOfMaps.get(0).get("objectName"));
		
		searchHotelPage.searchbutton.click();
	}




}
