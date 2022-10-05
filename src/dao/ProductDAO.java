package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Product;


public class ProductDAO implements DAOinterface<Product>{
	
	public static ProductDAO getInstance() {
		return new ProductDAO();
	}

	@Override
	public int insert(Product t) {
		int result = 0;
		try {
			// Bước 1: Tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			//Bước 3: Thực thi câu lệnh SQL
			String sql = "INSERT INTO product (id, Name, Price)"+
					" VALUES ('"+t.getId()+"' , '"+t.getName()+"' , '"+ t.getPrice()+"')";	
			
				 result = st.executeUpdate(sql);
					
				
				//Bước 4:
				System.out.println("You have excecuted: "+ sql);
				System.out.println("Got "+ result+" product changed!");

				// Bước 5: 
				JDBCUtil.closeConnection(con);
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int update(Product t) {
		int result = 0;
		try {
			// Bước 1: Tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			//Bước 3: Thực thi câu lệnh SQL
			String sql = "UPDATE product "+
					 " SET " +
					 " name='"+ t.getName()+"'"+
					 ", price="+ t.getPrice()+
					 " WHERE id='"+t.getId()+"\'";
			System.out.println(sql);
				 result = st.executeUpdate(sql);
					
				
				//Bước 4:
				System.out.println("You have execute: "+ sql);
				System.out.println("Got "+ result+" product changed!");

				// Bước 5: 
				JDBCUtil.closeConnection(con);
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int delete(Product t) {
		int result = 0;
		try {
			// Bước 1: Tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			//Bước 3: Thực thi câu lệnh SQL
			String sql = "DELETE from product "+
					 " SET " +
					 " WHERE id='"+t.getId()+"'";
			System.out.println(sql);
				 result = st.executeUpdate(sql);
					
				
				//Bước 4:
				System.out.println("You have execute: "+ sql);
				System.out.println("Got "+ result+" product changed!");

				// Bước 5: 
				JDBCUtil.closeConnection(con);
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public ArrayList<Product> selectAll() {
		ArrayList<Product> result = new ArrayList<Product>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM product";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				
				Product product = new Product(id, name, price);
				result.add(product);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Product selectById(Product t) {
		Product result = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM product where id='"+t.getId()+"'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				
				result = new Product(id, name, price);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<Product> selectByCondition(String condition) {

		ArrayList<Product> result = new ArrayList<Product>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM product where "+ condition;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");

				
				Product product = new Product(id, name, price);
				result.add(product);
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
