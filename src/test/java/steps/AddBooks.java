package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddBooks {

	ChromeDriver driver = null;
	
	@Given("user should navigate to application")
	public void userShouldNavigateToApplication() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://bookcart.azurewebsites.net/");
	}
	@Then("user click on loing button")
	public void userClickOnLoingButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//span[.=' Login ']")).click();
	}
	@Then("user should enter {string}")
	public void userShouldEnter(String string) {
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys(string);
	}
	@When("user should search {string} and add to cart")
	public void userShouldSearchAndAddToCart(String string) {
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(string, Keys.ENTER);
	}
	@Then("cart iteam should be increased")
	public void cartIteamShouldBeIncreased() {
	 
	}

}
