package EXCUTE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import MODEL.*;
import PAGE.*;

public class ecommerce {
	CommonBase commonBase;
	WebDriver driver;
	String product = "iphone 11";
	TikiSearchPage tikiSearchPage;
	TikiPage tikiPage;
	EbayPage ebayPage;
	EbaySearchPage ebaySearchPage;
	CollectionSort collectonSort;

	@BeforeMethod
	public void innit() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\DRIVER\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://tiki.vn/");
		driver.manage().window().maximize();

		tikiPage = new TikiPage(driver);
		tikiSearchPage = new TikiSearchPage(driver);
		ebayPage = new EbayPage(driver);
		ebaySearchPage = new EbaySearchPage(driver);
	}

	@Test
	public void Test() throws InterruptedException {
		tikiPage.setTxtSearch(product);
		tikiPage.clickBtnSearch();
		Thread.sleep(1000);
		// check result
		tikiSearchPage.clickBoQua();
		tikiSearchPage.checkResultSearch();

		List<Product> list = new ArrayList<Product>();
		list = tikiSearchPage.listProduct();
		// open Ebay
		ebayPage.openEbay();
		ebayPage.setTxtSearch(product);
		ebayPage.clickBtnSearch();
		// check result
		ebaySearchPage.checkResultSearch(product);

		list.addAll(ebaySearchPage.listProduct());
		Collections.sort(list, new CollectionSort());
		// print list product sorted by price
		ebaySearchPage.printList(list);

	}

	@AfterTest
	public void after() {
		driver.quit();
	}
}
