package steps;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepsDefinition {
	WebDriver driver;
	@Before
	public void setUp() {
		System.out.println();
	}
	@After
	public void tearDown() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	@AfterStep
	public void screenshot() {
		System.out.println("screenshot is taken");
	}
	
	@Given("user starts {string} browser")
	public void user_starts_browser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();		
		}	   
	}

	@Given("user launch app using url {string}")
	public void user_launch_app_using_url(String url) {
	    driver.get(url);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("user enters text {string} in textbox using xpath {string}")
	public void user_enters_text_in_textbox_using_xpath(String text, String xpath) {
		driver.findElement(By.xpath(xpath)).sendKeys(text);	    
	}

	@When("user clicks button using xpath {string}")
	public void user_clicks_button_using_xpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();	   
	}

	@Then("user verifies title to be {string}")
	public void user_verifies_title_to_be(String expTitle) {
		Assert.assertEquals(expTitle,driver.getTitle());	    
	}
	
	@When("user click using xpath {string}")
	public void user_click_using_xpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();	    
	}
	@When("user enters details in registration form")
	public void user_enters_details_in_registration_form(DataTable dataTable) {
	    
		List<List<String>> allLists=dataTable.asLists();
		
 driver.findElement(By.xpath("//input[@name='username']")).sendKeys(allLists.get(0).get(0));
 driver.findElement(By.xpath("//input[@name='password']")).sendKeys(allLists.get(0).get(1));
 driver.findElement(By.xpath("//input[@name='re_password']")).sendKeys(allLists.get(0).get(2));	
 driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys(allLists.get(0).get(3));
 driver.findElement(By.xpath("//input[@name='email_add']")).sendKeys(allLists.get(0).get(4));
 driver.findElement(By.xpath("//input[@name='captcha']")).sendKeys(allLists.get(0).get(5));
 
	}



}
