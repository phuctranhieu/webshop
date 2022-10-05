package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Category;


public class CategoryDAO implements DAOinterface<Category>{
	
	public static CategoryDAO getInstance() {
		return new CategoryDAO();
	}

	@Override
	public int insert(Category ca) {
		int result = 0;
		try {
			// Bước 1: Tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			//Bước 3: Thực thi câu lệnh SQL
			String sql = "INSERT INTO category (id, name)"+
					" VALUES ('"+ca.getId()+"' , '"+ca.getName()+"')";	
			
				 result = st.executeUpdate(sql);
					
				
				//Bước 4:
				System.out.println("You got: "+ sql);
				System.out.println("Got "+ result+" Category changed!");

				// Bước 5: 
				JDBCUtil.closeConnection(con);
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int update(Category ca) {
		int result = 0;
		try {
			// Bước 1: Tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			//Bước 3: Thực thi câu lệnh SQL
			String sql = "UPDATE category "+
					 " SET " +
					 " name='"+ ca.getName()+"'"+
					 " WHERE id='"+ca.getId()+"\'";
			System.out.println(sql);
				 result = st.executeUpdate(sql);
					
				
				//Bước 4:
				System.out.println("You got: "+ sql);
				System.out.println("Got "+ result+" category changed!");

				// Bước 5: 
				JDBCUtil.closeConnection(con);
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int delete(Category ca) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Category> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category selectById(Category ca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Category> selectByCondition(String condition) {
		ArrayList<Category> result = new ArrayList<Category>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM category";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
			
				
				Category ca =new Category(id, name);
				result.add(ca);
	}
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
