package PAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TikiPage extends CommonBase{
	WebDriver driver;
	public TikiPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@data-view-id='main_search_form_input']")
	WebElement txtSearch;
	@FindBy(xpath = "//button[@data-view-id='main_search_form_button']")
	WebElement btnSearch;
	
	public void setTxtSearch(String values) {
		waitForPageLoaded(driver);
		setText(txtSearch,driver, values);

	}
	
	public void clickBtnSearch() {
		Click(btnSearch, driver);	
		waitForPageLoaded(driver);
	}
}
