package mobile.automation;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class test1 {

	@Given("launch the mobile")
	public void launch_the_mobile() {
		AppiumDriver driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Pixel 3");
		capabilities.setCapability("platformVersion", "9");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.google.android.calculator");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

		System.out.println("Capabalities has been loaded");
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

		} catch (Exception e) {

		}

	}

	@Then("validate the header")
	public void validate_the_header() {
		System.out.println("Driver created successfully");
	}

	// input[@placeholder="First Name"]
	// input[@placeholder="Last Name"]
	public static WebDriver driver;
	@Given("launch URL")
	public void launch_URL() {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\39543\\Documents\\Projectworkspace\\automation\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
	}

	@When("enters data")
	public void enters_data(io.cucumber.datatable.DataTable dataTable) {
		
		List<String> asList = dataTable.asList(String.class);
		
		System.out.println(asList);
		driver.findElement(By.xpath("// input[@placeholder=\"First Name\"]")).sendKeys(asList.get(1));
		driver.findElement(By.xpath("// input[@placeholder=\"Last Name\"]")).sendKeys(asList.get(0));
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
	
	}

	@Then("validate header")
	public void validate_header() {
		System.out.println("Completed");
	}
	
	@When("enters datas")
	public void enters_datas(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> dt = dataTable.asMaps(String.class,String.class);
		
		//List<List<String>> dt = dataTable.asLists(String.class);
		String string = dt.get(0).get("fname");
		driver.findElement(By.xpath("// input[@placeholder=\"First Name\"]")).sendKeys(dt.get(0).get("fname"));
		//driver.findElement(By.xpath("// input[@placeholder=\"Last Name\"]")).sendKeys(dt.get(1).get(1));
		
	}
	

}
