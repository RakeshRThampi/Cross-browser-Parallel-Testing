package Base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
	protected WebDriver driver;
	private WebDriverWait wait;
	private final long DRV_WAIT = 3;
	private final long IMP_WAIT = 3;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeTest(@Optional("chrome") String browser, String url) throws Exception {
		System.out.println("BaseClass::beforeTest - Browser = " + browser + ", URL = " + url);
		initializeBrowser(browser, url);
		wait = new WebDriverWait(driver, Duration.ofSeconds(DRV_WAIT));
		driver.get(url);
		Assert.assertTrue(true, "BaseClass::beforeTest() -Browser initialization failed");
		System.out.println("BaseClass::beforeTest - Browser initialized successfully!");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BaseClass::beforeMethod()");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("BaseClass::afterMethod()");
	}

	public void waitByVisibility(By by) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	private void initializeBrowser(String browser, String url) throws Exception {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new Exception("Incorrect Browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMP_WAIT));
	}

	@AfterTest
	public void afterTest() {
		System.out.println("BaseClass::afterTest");
		driver.quit();
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BaseClass::beforeSuite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("BaseClass::afterSuite");
	}
}
