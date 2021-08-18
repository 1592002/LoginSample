package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	static WebDriver driver;

	@Given("User is on login screen")
	public void user_is_on_login_screen() {
		System.out.println("user is on login page");
		// Launch Chrome Driver
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		// Launch the web application
		driver.get("http://the-internet.herokuapp.com/login");

	}

	@When("User input vaild tomsmith and <Password>")
	public void user_input_vaild_tomsmith_and_password() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("User enter uasername and password");
		// Enter Username
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tomsmith");
		// Enter Password
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("SuperSecretPassword!");
	}

	@Then("User Should able to login successfully and success message displays")
	public void user_should_able_to_login_successfully_and_success_message_displays() throws IOException {
		// Write code here that turns the phrase above into concrete actions

		System.out.println("Userclick on the login button ");
		// Click on the login Button
		driver.findElement(By.xpath("//*[@id='login']/button")).click();
		// Call take screenshot function for first time
		takeScreenShot("vaildUser"+System.currentTimeMillis());
		driver.close();
	}

	@Given("User is on login screen1.")
	public void user_is_on_login_screen1() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("user is on a login page");
		System.out.println("user is on login page");
		// Launch Chrome Driver
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		// Launch the web application
		driver.get("http://the-internet.herokuapp.com/login");

	}

	@When("User input worng vamsi and <Password>")
	public void user_input_worng_vamsi_and_password() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("User enter uasername and password");
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tom");
		// Enter Password
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("SuperSecretPa");

	}

	@Then("User Should not able to login and invalid password message displays")
	public void user_should_not_able_to_login_and_invalid_password_message_displays() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("User click on the login button ");
		// Click on the login Button
		driver.findElement(By.xpath("//*[@id='login']/button")).click();
		// Call take screenshot function for first time
		takeScreenShot("invaildUser"+System.currentTimeMillis());
		driver.close();

	}

	// Screenshot method
	public static void takeScreenShot(String fileName) throws IOException {

		// Take a screenshot and store it as file
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Copy the Screenshot to desired location using copyfile method:
			Files.copy(file, new File("/Users/vamsi/eclipse-workspace/LoginSample/target/ScreenShots/"+fileName+".jpg"));
	

	}
}