package Tests;

import Base.BaseClass;
import Pages.Page1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 extends BaseClass {
	private Page1 page1;

	@Test(priority=1)
	public void testPageLoad() {
		System.out.println("Test1::testPageLoad()");
		page1 = new Page1(driver);
		String expURL = "https://www.saucedemo.com/v1/";
		Assert.assertEquals(page1.getPageUrl(), expURL);
	}

	@Test(priority=2)
	public void loginSwagLabs() {
		System.out.println("Test1::loginSwagLabs()");
		String username = "standard_user";
		String password = "secret_sauce";
		Assert.assertTrue(page1.loginStandardUser(username, password));
	}
}
