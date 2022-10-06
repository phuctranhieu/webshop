package TEST;

import java.util.Iterator;

import dao.CategoryDAO;
import dao.ProductDAO;
import dao.ProductDAO;
import model.Category;
import model.Product;
import model.Product;

public class TestProductDAO {
	public static void main(String[] args) {

		//insert
		Product product1 = new Product("1", "abcd", 50000);
		Product product2 = new Product("0", "mnk", 70000);
		
		ProductDAO.getInstance().insert(product2);
		
		//update
		Product product3 = new Product("3", "new product", 100000);
		ProductDAO.getInstance().update(product3);
	
		//delete
		Product product = new Product("3", "new product", 100000);
		ProductDAO.getInstance().delete(product);
		
		//select all
		ProductDAO.getInstance().selectAll();
		
	
	}
}	
	
		