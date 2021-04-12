package EXCUTE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Pause;
import org.testng.annotations.*;

import MODEL.Product;
import PAGE.*;

public class ecommerce {
	CommonBase commonBase2;
	WebDriver driver;
	String product ="iphone 11";
	TikiSearchPage tikiSearchPage;
	TikiPage tikiPage;
	TikiDetailProduct tikiDetailProduct;
	EbayPage ebayPage;
	EbaySearchPage ebaySearchPage ;
	EbayDetailProduct ebayDetailProduct;
	@BeforeMethod
	public void innit() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\DRIVER\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://tiki.vn/");
		driver.manage().window().maximize();
		
		tikiPage = new TikiPage(driver);
		tikiSearchPage = new TikiSearchPage(driver);
		tikiDetailProduct = new TikiDetailProduct(driver);		
		ebayPage = new EbayPage(driver);
		ebaySearchPage =  new EbaySearchPage(driver);
		ebayDetailProduct = new EbayDetailProduct(driver);
	}

	@Test
	public void Test() throws InterruptedException {
		tikiPage.setTxtSearch(product);
		tikiPage.clickBtnSearch();
		//check result
		tikiSearchPage.checkResultSearch();
		tikiSearchPage.clickProduct();
		
		String tikiPrice =tikiDetailProduct.trimPrice();
		String tikiUrl = tikiDetailProduct.getCurrentUrl();
		String tikiName = tikiDetailProduct.getName();
		//open Ebay
		ebayPage.openEbay();
		ebayPage.setTxtSearch("iphone 11");
		ebayPage.clickBtnSearch();
		//check result
		ebaySearchPage.checkResultSearch(product);
		ebaySearchPage.clickProduct();
		
		String ebayPrice =ebayDetailProduct.trimPrice();
		String ebayUrl = ebayDetailProduct.getCurrentUrl();
		String ebayName = ebayDetailProduct.getName();

		//print the output
		ArrayList<Product> tikiProduct = new ArrayList<Product>();;
		Product tp = new Product("Tiki", tikiName, tikiUrl,tikiPrice);
		tikiProduct.add(tp);
		ArrayList<Product> ebayProduct = new ArrayList<Product>();;
		Product ep = new Product("Tiki", ebayName, ebayUrl,ebayPrice);
		ebayProduct.add(ep);
		
		try {
			double price = Double.parseDouble(tikiProduct.get(0).getPrice());
			double priceEbay = Double.parseDouble(ebayProduct.get(0).getPrice());
			if(price<priceEbay) {
				for (Product pd : tikiProduct) {
					System.out.println(pd.getWebsite() + " " + pd.getName() + " " + pd.getPrice()+ " " + pd.getUrl());
				}
				for (Product pd : ebayProduct) {
					System.out.println(pd.getWebsite() + " " + pd.getName() + " " + pd.getPrice()+ " " + pd.getUrl());
				}
			}else {
				for (Product pd : ebayProduct) {
					System.out.println(pd.getWebsite() + " " + pd.getName() + " " + pd.getPrice()+ " " + pd.getUrl());
				}
				for (Product pd : tikiProduct) {
					System.out.println(pd.getWebsite() + " " + pd.getName() + " " + pd.getPrice()+ " " + pd.getUrl());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@AfterTest
	public void after() {
		driver.quit();
	}
}
