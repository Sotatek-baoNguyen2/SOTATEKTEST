package PAGE;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import MODEL.Product;


public class CommonBase {

	public void Click(WebElement element, WebDriver driver) {
		waitForPageLoaded(driver);
		element.click();

	}
	public void getURL(String url, WebDriver driver) {
		driver.get(url);
		pause(1000);
	}

	public void pause(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setText(WebElement element, WebDriver driver, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			if (element != null) {
				wait.until(ExpectedConditions.visibilityOf(element));
				element.clear();
				element.sendKeys(value);
			} else {
				wait.until(ExpectedConditions.visibilityOf(element));
				element.sendKeys(value);
			}
		} catch (StaleElementReferenceException e) {
			pause(1000);
			setText(element, driver, value);
		} catch (NoSuchElementException e) {
			pause(1000);
			setText(element, driver, value);
		} catch (ElementNotVisibleException e) {
			pause(1000);
			setText(element, driver, value);
		}
	}

	public void waitForPageLoaded(WebDriver driver) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			error.getCause().toString();
		}
	}

	public String getText(WebElement element) {
		try {
			return element.getText();
		} catch (StaleElementReferenceException e) {
			pause(1000);
			return getText(element);
		}
	}
	public Boolean verifyElementText(WebElement element, String text) {
		Boolean check = false;
		try {
			if (element.getText() == text) {
				check = true;
			}
		} catch (StaleElementReferenceException e) {
			pause(1000);
			return false;
		} 
		return check;
	}
	public String trimCharactor(String input, String trim) {
		if (input != "" && input != null && trim != "") {
			if (trim == ".") {
				return input.replaceAll("\\.", "");
			} else {
				return input.replaceAll(trim, "");
			}
		} else
			return "";
	}

	public WebElement getElement(String locator, WebDriver driver) {
		WebElement elem = null;
		try {
			elem = driver.findElement(By.xpath(locator));
		} catch (NoSuchElementException e) {
			getElement(locator, driver);
		} catch (StaleElementReferenceException e) {;
			getElement(locator, driver);
		}
		return elem;
	}
	public String getAttribute(WebElement element) {
		return element.getAttribute("href").toString();
	}
	public String getListAttribute(WebElement element) {
		return element.getAttribute("href").toString();
	}
	public List<WebElement> getListElements(String locator, WebDriver driver) {
		List<WebElement> elements = null;
		try {
			elements = driver.findElements(By.xpath(locator));
		} catch (NoSuchElementException e) {
			getElement(locator, driver);
		} catch (StaleElementReferenceException e) {;
			getElement(locator, driver);
		}
		return elements;
	}
	public void printList(List<Product> list) {
		for (Product pd : list) {
			System.out.println(pd.getWebsite() + "  Name: " + pd.getName() + "  Price: " + pd.getPrice()+ "   Link to detail:" + pd.getUrl());
		}
	}
	
}

