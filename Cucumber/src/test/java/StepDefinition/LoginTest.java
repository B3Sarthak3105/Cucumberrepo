package StepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {
	
	public static WebDriver driver;
	PageObjects po;
	
	@Given("^Navigate to Home page$") 
	public void Navigate_to_Home_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\New folder\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		po=new PageObjects(driver);
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
	}
	
	@When("^user enters username and password$")
	public void user_enters_username_and_password() throws Throwable{
		po.signin.click();
		po.username.sendKeys("lalitha");
		po.password.sendKeys("Password123");
		po.Login.click();	
	}
	
	@Then("^user logged in successfully$")
	public void user_logged_in_successfully() throws Throwable{
		System.out.println("user login successfully");
		
	}
	
	@When("^Larry searches below products in the search box:$")
	public void Larry_searches_below_procuts_in_the_search_box(DataTable dataTable) {
		
		List<String>product=dataTable.asList(String.class);
		for(String s : product) {
			driver.findElement(By.name("products")).sendKeys(s);
			driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
			driver.findElement(By.xpath("//a[@href='logout.htm']")).click();
			
		}
	}
	
	
	
	@Then("^product should be added in the cart if available$")
	public void product_should_be_added_in_the_cart_if_available()  {
		
		System.out.println("added");
	}
	
	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")

	public void entersunamepwd(String username, String password) {

	po.signin.click();

	po.username.sendKeys(username);

	po.password.sendKeys(password);

	po.Login.click();

	}
	

}
