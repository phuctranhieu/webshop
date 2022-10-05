package TEST;

import java.util.ArrayList;
import dao.CategoryDAO;
import model.Category;

public class TestCategoryDao {
	public static void main(String[] args) {
		ArrayList<Category> list = CategoryDAO.getInstance().selectAll();
		for (Category ca : list) {
			System.out.println(ca.toString());
}
}}