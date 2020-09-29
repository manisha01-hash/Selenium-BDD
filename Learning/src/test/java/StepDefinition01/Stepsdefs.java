package StepDefinition01;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Stepsdefs {
	WebDriver driver;
	@Before
	public void beforetest()
	{
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	}
	@Given("I am able to navigate onto Signin page")
	public void i_am_able_to_navigate_onto_signin_page() {
		driver.get("http://elearningm1.upskills.in/");
		   driver.findElement(By.xpath("//div[@class='sidebar']/div/div/ul/li[1]")).click(); 
	}

	@Given("User enters {string} and {string}")
	public void user_enters_and(String string, String string2) {
		driver.findElement(By.id("registration_firstname")).sendKeys(string); 
		 driver.findElement(By.id("registration_lastname")).sendKeys(string2);
	}

	@And("User enters {string} and {string} and {string}")
	public void user_enters_and_and(String string, String string2, String string3) {
		driver.findElement(By.id("registration_email")).sendKeys(string); 
		 driver.findElement(By.id("username")).sendKeys(string2);
		 driver.findElement(By.id("pass1")).sendKeys(string3);
	}

	@And("User provide the {string} for confirmation")
	public void user_provide_the_for_confirmation(String string) {
		driver.findElement(By.id("pass2")).sendKeys(string);
	}

	@And("I click on the login button")
	public void i_click_on_the_login_button() {
		driver.findElement(By.id("registration_submit")).click();
	}

	@Then("I should see the username as {string}")
	public void i_should_see_the_username_as(String string) {
		 System.out.println("signup is successful");
		    
		    driver.close();
	}

	@Given("User is in the home page")
	public void user_is_in_the_home_page() {
		driver.get("http://elearningm1.upskills.in/");
	}
	
		
	

	@And("I click on the login button and click on the login_icon")
	public void i_click_on_the_login_button_and_click_on_the_login_icon() {
		 driver.findElement(By.id("login")).sendKeys("manisha.dey");
		    driver.findElement(By.id("password")).sendKeys("Doremon$123");
		    driver.findElement(By.id("form-login_submitAuth")).click();
		   driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul[2]/li[2]/a")).click();
	}

	@And("Click on inbox and select compose message")
	public void click_on_inbox_and_select_compose_message() {
		
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li/a[@title='Inbox']")).click();
		driver.findElement(By.xpath("//div[@class='row']/div/a/img[@title='Compose message']")).click();
	}

	@And("select the send to id")
	public void select_the_send_to_id() throws InterruptedException {
		driver.findElement(By.xpath("//span[@class='selection']/span/ul/li/input")).sendKeys("tan");
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ENTER).keyUp(Keys.CONTROL).build().perform();
		
		
	}

	@And("Write the subject of the email")
	public void write_the_subject_of_the_email() {
		driver.findElement(By.id("compose_message_title")).sendKeys("Confirmation mail");
		
	}

	@And("the message needs to be sent")
	public void the_message_needs_to_be_sent() throws InterruptedException {
		Thread.sleep(10000);
		driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[@title='Rich Text Editor, content']")));
        driver.switchTo().activeElement().sendKeys("Hello Manisha\n This is for testing");
        driver.switchTo().defaultContent();
	}

	@Then("click on send")
	public void click_on_send() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		 WebElement sendButton= driver.findElement(By.id("compose_message_compose"));
         js.executeScript("arguments[0].scrollIntoView(true);", sendButton);
         Thread.sleep(5000);
         sendButton.click();
         driver.close();
        
	}
}
