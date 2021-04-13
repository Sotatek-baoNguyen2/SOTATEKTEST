package MODEL;

import java.util.Comparator;

public class Product {

	String url, name, website, price;
	public Product(String website, String name, String url, String price) {
		this.website=website;
		this.name=name;
		this.url=url;
		this.price=price;
		
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
