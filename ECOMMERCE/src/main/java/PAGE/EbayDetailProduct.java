package PAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayDetailProduct extends CommonBase {
	WebDriver driver;
	@FindBy(id = "convbidPrice")
	WebElement price;
	@FindBy(id = "itemTitle")
	WebElement prductName;
	public EbayDetailProduct(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPrice() {
		waitForPageLoaded(driver);
		return getText(price);
	}
	public String getName() {
		waitForPageLoaded(driver);
		return getText(prductName);
	}
	public String trimPrice() {
		String Price = trimCharactor(
				trimCharactor(getPrice(), ","), "VND");
		return Price;
	}
	public String getCurrentUrl() {
		return driver.getCurrentUrl();		
	}
}
