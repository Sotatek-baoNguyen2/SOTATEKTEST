package MODEL;

import java.util.Comparator;

public class CollectionSort implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		return (int) (Double.parseDouble(o1.price)-Double.parseDouble(o2.price));
	}

}
