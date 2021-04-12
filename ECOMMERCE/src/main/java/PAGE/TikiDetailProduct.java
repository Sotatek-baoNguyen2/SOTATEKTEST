package PAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TikiDetailProduct extends CommonBase{
	WebDriver driver;
	@FindBy(xpath = "//*[@class='product-price__current-price']")
	WebElement price;
	@FindBy(xpath = "//*[@data-view-id='pdp_details_title_tikinow_logo']/../..//.")
	WebElement prductName;
	public TikiDetailProduct(WebDriver driver) {
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
				trimCharactor(getPrice(), "₫"), ".");
		return Price;
	}
	public String getCurrentUrl() {
		return driver.getCurrentUrl();		
	}
}
