package PAGE;

import java.nio.charset.Charset;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TikiSearchPage extends CommonBase{
	WebDriver driver;
	public TikiSearchPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@class='product-item']//span[contains(text(),'iPhone 11')][1]")
	WebElement Product;
	@FindBy(xpath = "//*[contains(text(),'Kết quả tìm kiếm cho')]//following-sibling::h4")
	WebElement result;
	
	public void clickProduct() {
		waitForPageLoaded(driver);
		Click(Product, driver);
	}
	public String getText() {
		waitForPageLoaded(driver);
		return result.getText();	
	}
	public void checkResultSearch() {
		if(verifyElementText(result, "0 kết quả")==true) {
			System.out.println("No product");
		}else {
			System.out.println("Have an product");
		}
		
	}
//	public void checkResult() {
//		verifyElementText(result, " ");
//		Assert.assertEquals(getText(), "0 kết quả");
//	}
}
