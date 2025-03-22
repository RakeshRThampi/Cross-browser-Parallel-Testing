package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.Page2;

public class Test2 extends BaseClass {
	private Page2 page2;

	@Test(priority = 1)
	public void validateSortOptions() {
		System.out.println("Test1::validateSortOptions() driver = " + driver);
		page2 = new Page2(driver);
		Assert.assertTrue(page2.validateSortOptions());
	}

	@Test(priority = 2)
	public void sortProducts() {
		System.out.println("Test2::sortProducts()");
		page2.sortByIndex(1);
	}
}
