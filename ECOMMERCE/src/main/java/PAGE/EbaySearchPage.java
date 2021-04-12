package PAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbaySearchPage extends CommonBase{
	WebDriver driver;
	public EbaySearchPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@id='srp-river-results']//li[@class = 's-item      ']/div/div[2]/a[1]")
	WebElement Product;
	@FindBy(xpath = "//*[@class='srp-controls__count-heading']")
	WebElement result;
	
	public void clickProduct() {
		waitForPageLoaded(driver);
		Click(Product, driver);
	}
	public String getText() {
		waitForPageLoaded(driver);
		return result.getText();	
	}
	public void checkResultSearch(String value) {
		if(verifyElementText(result, "0 results for "+value)==true) {
			System.out.println("No product");
		}else {
			System.out.println("Have an product");
		}
		
	}
}
