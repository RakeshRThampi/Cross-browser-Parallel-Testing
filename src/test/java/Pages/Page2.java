package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Page2 {
	private WebDriver driver;
	Select sortSel;
	private By sortObjectBy = By.xpath("//select[@class='product_sort_container']");

	public Page2(WebDriver driver) {
		System.out.println("Page2() driver = " + driver);
		this.driver = driver;
	}

	public boolean validateSortOptions() {
		System.out.println("Page2::validateSortOptions()");
		sortSel = new Select(driver.findElement(sortObjectBy));
		List<WebElement> sortOptionElems = sortSel.getOptions();
		Iterator<WebElement> it = sortOptionElems.iterator();
		WebElement ele;
		while (it.hasNext()) {
			ele = it.next();
			System.out.println("Page2::validateSortOptions() A Option = " + ele.getText());
		}
		for (WebElement elem : sortOptionElems) {
			System.out.println("Page2::validateSortOptions() B Option = " + elem.getText());
		}
		return true;
	}

	public boolean sortByIndex(int index) {
		System.out.println("Page2::sortByIndex()");
		sortSel.selectByIndex(index);
		return true;
	}

}
