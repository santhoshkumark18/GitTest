package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BookcartLogin {

	ChromeDriver driver = null;

	@Given("User should navigate to the application")
	public void userShouldNavigateToTheApplication() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://bookcart.azurewebsites.net/");

	}

	@Given("User should click on login link")
	public void userShouldClickOnLoginLink() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//span[.=' Login ']")).click();

	}

	@Given("User should enter user name as ortoni")
	public void userShouldEnterUserNameAsOrtoni() {
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("ortoni");
	}

	@When("User should enter password as pass1234")
	public void userShouldEnterPasswordAsPass1234() {
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("pass1234", Keys.ENTER);
	}

	@Then("User should sign successfull")
	public void userShouldSignSuccessfull() throws InterruptedException {
		Thread.sleep(5000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement username = driver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-toolbar/mat-toolbar-row/div[3]/a[1]/span[2]/span"));
		wait.until(ExpectedConditions.elementToBeClickable(username));
		String text = username.getText();
		System.out.println(text);
		driver.quit();
	}
	
	@Given("User should enter user name as {string}")
	public void userShouldEnterUserNameAs(String username) {
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys(username);
	}
	@When("User should enter password as {string}")
	public void userShouldEnterPasswordAs(String pswd) {
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(pswd, Keys.ENTER);
	}
	@When("Login should failed")
	public void loginShouldFailed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement errormsg = driver.findElement(By.id("mat-mdc-error-0"));
		String errorMessage = wait.until(ExpectedConditions.visibilityOf(errormsg)).getText();
		Assert.assertEquals(errorMessage, "Username or Password is incorrect.");
		driver.quit();
	}

}
