package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page1 {
	private WebDriver driver;
	private By unBy = By.xpath("//input[@id=\"user-name\"]");
	private By pwBy = By.xpath("//input[@id=\"password\"]");
	private By loginBtnBy = By.id("login-button");

	public Page1(WebDriver driver) {
		System.out.println("Page1() driver = " + driver);
		this.driver = driver;
	}

	public String getPageUrl() {
		System.out.println("Page1::getPageUrl() - URL = " + driver.getCurrentUrl());
		return driver.getCurrentUrl();

	}

	public boolean loginStandardUser(String username, String password) {
		System.out.println("Page1::loginStandardUser() - User name = " + username + ", Password = " + password);
		driver.findElement(unBy).clear();
		driver.findElement(pwBy).clear();
		driver.findElement(unBy).sendKeys(username);
		driver.findElement(pwBy).sendKeys(password);
		driver.findElement(loginBtnBy).click();
		String productsUrl = "https://www.saucedemo.com/v1/inventory.html";
		return (driver.getCurrentUrl().equals(productsUrl));
	}
}
