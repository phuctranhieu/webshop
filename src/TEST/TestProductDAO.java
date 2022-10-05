package TEST;

import java.util.Iterator;

import dao.ProductDAO;
import dao.ProductDAO;
import model.Product;
import model.Product;

public class TestProductDAO {
	public static void main(String[] args) {


		Product product1 = new Product("LTJV", "abcd", 50000);
		Product product2 = new Product("zyx", "mnk", 70000);
		
		ProductDAO.getInstance().insert(product2);
		
		Product product3 = new Product("LTC", "new product", 100000);
		ProductDAO.getInstance().update(product3);
	
		
	}
}	
	
		