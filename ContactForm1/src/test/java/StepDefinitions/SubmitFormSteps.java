package StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SubmitFormSteps {
	
	WebDriver driver;
	
	@Before
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
	
	@Given("^User is on Basic Contact Form sign up page$")
	public void invokeApplication() {
		driver.get("https://www.mycontactform.com/samples/basiccontact.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
	
	@Then("^Your Name, Email Address and Message is visible$")
	public void verifyInputFieldsArePresent() {
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='q[1]']")).isEnabled());
		Assert.assertTrue(driver.findElement(By.id("email")).isEnabled());
		Assert.assertTrue(driver.findElement(By.name("q[2]")).isEnabled());
	}
	
	@Then("^user fills in the details in the above respective fields$")
	public void sendDataToInput(DataTable credentials) {
		List<String> testData=credentials.asList();
		driver.findElement(By.xpath("//input[@name='q[1]']")).sendKeys(testData.get(0));
		driver.findElement(By.id("email")).sendKeys(testData.get(1));
		driver.findElement(By.name("q[2]")).sendKeys("Hello World");
		driver.findElement(By.name("submit")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
