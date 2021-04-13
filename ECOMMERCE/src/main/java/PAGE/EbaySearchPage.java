package PAGE;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MODEL.Product;

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
	public List<Product> listProduct() {
		List<Product> listProduct = new ArrayList<Product>();
		for (int i = 0; i < 10; i++) {
			Product tp = new Product("Ebay", getListNameProduct().get(i).getText(), getListUrlProduct().get(i),
					trimPrice(getListPriceProduct().get(i).getText()));
			listProduct.add(tp);
		}
		return listProduct;
	}

	// get list
	
	public List<WebElement> getUrlProduct() {
		return getListElements("//a[contains(@class,'s-item__link')]", driver);// *[@class='product-item']
	}
	public List<WebElement> getListProduct() {
		return getListElements("//li[contains(@class,'s-item    ')]", driver);// *[@class='product-item']
	}

	public List<WebElement> getListNameProduct() {
		return getListElements("//h3[contains(@class,'s-item__title')]", driver);
	}

	public List<WebElement> getListPriceProduct() {
		return getListElements("//span[contains(@class,'s-item__price')]", driver);
	}

	public List<String> getListUrlProduct() {
		List<String> list = new ArrayList<>();
		for (WebElement element : getUrlProduct()) {
			list.add(element.getAttribute("href"));
		}
		return list;
	}
	
	public String trimPrice(String value) {
		String Price = trimCharactor(
				trimCharactor(value, ","), "VND");
		return Price;
	}
}
