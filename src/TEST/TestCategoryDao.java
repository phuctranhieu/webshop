package TEST;

import java.util.ArrayList;
import dao.CategoryDAO;
import model.Category;

public class TestCategoryDao {
	public static void main(String[] args) {
		ArrayList<Category> list = CategoryDAO.getInstance().selectAll();
		for (Category ca : list) {
			System.out.println(ca.toString());
			
			//insert
			Category category = new Category(0,"Book");
			CategoryDAO.getInstance().insert(category);
			
			//update
			
			Category category1 = new Category(8,"Phone");
			CategoryDAO.getInstance().update(category1);
			
			// seclect by name Category
			 Category category2 = new Category(133,"Desk");
			if(CategoryDAO.getInstance().selectById(category2).getNameCategory()==null) {
				System.out.println("Empty");
			}else {
				System.out.println( CategoryDAO.getInstance().selectById(category));
			
}
}}}