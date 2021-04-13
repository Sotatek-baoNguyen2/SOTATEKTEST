package MODEL;

import java.util.Comparator;

public class CollectionSort implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		return (int) (Double.parseDouble(o1.price)-Double.parseDouble(o2.price));
//		if(Double.parseDouble(o1.getPrice())>Double.parseDouble(o2.getPrice()))
//       	 return 1;
//        else if(Double.parseDouble(o1.getPrice())==Double.parseDouble(o2.getPrice())){
//			return 0;
//		}else {
//			return -1;
//		}
	}

}
