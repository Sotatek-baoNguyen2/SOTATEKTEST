package PAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayPage extends CommonBase{
	WebDriver driver;
	public EbayPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "gh-ac")
	WebElement txtSearch;
	@FindBy(id = "gh-btn")//*[@class='srp-controls__count-heading']
	WebElement btnSearch;
	@FindBy(id = "//*[@class='srp-controls__count-heading']")
	WebElement result;
	public void setTxtSearch(String values) {
		waitForPageLoaded(driver);
		setText(txtSearch,driver, values);

	}
	
	public void clickBtnSearch() {
		Click(btnSearch, driver);	
		waitForPageLoaded(driver);
	}
	public void openEbay() {
		getURL("https://www.ebay.com/", driver);
		waitForPageLoaded(driver);
	}
}
