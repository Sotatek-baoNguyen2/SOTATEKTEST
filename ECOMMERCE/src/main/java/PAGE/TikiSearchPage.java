package PAGE;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MODEL.Product;

public class TikiSearchPage extends CommonBase {
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
	@FindBy(xpath = "//*[@class='name']")
	WebElement allPrductName;
	@FindBy(id = "onesignal-slidedown-cancel-button")
	WebElement btnBoQua;

	public void clickProduct() {
		waitForPageLoaded(driver);
		Click(Product, driver);
	}

	public void clickBoQua() throws InterruptedException {
		waitForPageLoaded(driver);
		if (!btnBoQua.isDisplayed()) {
			Thread.sleep(3000);
			Click(btnBoQua, driver);
		}
		Click(btnBoQua, driver);
	}

	public String getText(WebElement element) {
		waitForPageLoaded(driver);
		return element.getText();
	}

	public void checkResultSearch() {
		if (verifyElementText(result, "0 kết quả") == true) {
			System.out.println("No product");
		} else {
			System.out.println("Have an product");
		}
	}

	public List<Product> listProduct() {
		List<Product> listProduct = new ArrayList<Product>();
		for (int i = 0; i < 10; i++) {
			Product tp = new Product("Tiki", getListNameProduct().get(i).getText(), getListUrlProduct().get(i),
					trimPrice(getListPriceProduct().get(i).getText()));
			listProduct.add(tp);
		}
		return listProduct;
	}

	// get list
	public List<WebElement> getListProduct() {
		return getListElements("//*[@class='product-item']", driver);// *[@class='product-item']
	}

	public List<WebElement> getListNameProduct() {
		return getListElements("//*[@class='name']", driver);
	}

	public List<WebElement> getListPriceProduct() {
		return getListElements("//*[@class='price-discount__price']", driver);
	}

	public List<String> getListUrlProduct() {
		List<String> list = new ArrayList<>();
		for (WebElement element : getListProduct()) {
			list.add(element.getAttribute("href"));
		}
		return list;
	}
	public String trimPrice(String value) {
		String Price = trimCharactor(
				trimCharactor(value, "₫"), ".");
		return Price;
	}

}
