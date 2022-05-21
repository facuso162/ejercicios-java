package data;

import java.sql.*;
import java.util.LinkedList;
import entidades.Product;

public class ProductDAOJDBC implements ProductDAO{

	@Override
	public LinkedList<Product> list() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Product p = null;
		LinkedList<Product> productos = new LinkedList<>();
		try {
			conn = DbConnector.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM product");
			if(rs != null) {
				while(rs.next()) {
					//llamada a constructor 6b
					p = new Product(rs.getInt("id"), rs.getString("product_name"), rs.getString("product_desc"), rs.getDouble("price"), rs.getInt("stock"), rs.getBoolean("shippingIncluded"), rs.getDate("disabledOn"));
					productos.add(p);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			if(rs != null) {DbConnector.close(rs);};
			if(stmt != null) {DbConnector.close(stmt);};
			if(conn != null) {DbConnector.close(conn);};
		}
		return productos;
	}
	
	@Override
	public Product search(Product p) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DbConnector.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM product WHERE id = ?");
			pstmt.setInt(1, p.getId());
			rs = pstmt.executeQuery();
			if(rs != null && rs.next()) {
				p.setName(rs.getString("product_name"));
				p.setDescription(rs.getString("product_desc"));
				p.setPrice(rs.getDouble("price"));
				p.setStock(rs.getInt("stock"));
				p.setShippingIncluded(rs.getBoolean("shippingIncluded"));
				//ejercicio 6b
				p.setDisabledOn(rs.getDate("disabledOn"));
			} else p = null;
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			if(rs != null) {DbConnector.close(rs);};
			if(pstmt != null) {DbConnector.close(pstmt);};
			if(conn != null) {DbConnector.close(conn);};
		}
		return p;
	}
	
	@Override
	public Product newProduct(Product p) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet keyRS = null;
		try {
			conn = DbConnector.getConnection();
			//sentencia sql modificada para el ej 6b
			pstmt = conn.prepareStatement("INSERT INTO product (product_name, product_desc, price, stock, shippingIncluded, disabledOn) VALUES (?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getDescription());
			pstmt.setDouble(3, p.getPrice());
			pstmt.setInt(4, p.getStock());
			pstmt.setBoolean(5, p.isShippingIncluded());
			//ej 6b
			pstmt.setDate(6, p.getDisabledOn());
			pstmt.executeUpdate();			
			keyRS = pstmt.getGeneratedKeys();
			if( keyRS != null && keyRS.next()) {
				p.setId(keyRS.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			if(pstmt != null) {DbConnector.close(pstmt);};
			if(conn != null) {DbConnector.close(conn);};
		}
		return p;
	}
	
	@Override
	public void delete(Product p) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbConnector.getConnection();
			pstmt = conn.prepareStatement("DELETE FROM product WHERE id = ?");
			pstmt.setInt(1, p.getId());
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace(System.out);
		} finally {
			if(pstmt != null) {DbConnector.close(pstmt);};
			if(conn != null) {DbConnector.close(conn);};			
		}
	}
	
	@Override
	public void update(Product p) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DbConnector.getConnection();
			//modificado ej 6b
			pstmt = conn.prepareStatement("UPDATE product SET product_name = ?, product_desc = ?, price = ?, stock = ?, shippingIncluded = ?, disabledOn = ? WHERE id = ? ");
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getDescription());
			pstmt.setDouble(3, p.getPrice());
			pstmt.setInt(4, p.getStock());
			pstmt.setBoolean(5, p.isShippingIncluded());
			//ej 6b
			pstmt.setDate(6, p.getDisabledOn());
			pstmt.setInt(7, p.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			if(pstmt != null) {DbConnector.close(pstmt);};
			if(conn != null) {DbConnector.close(conn);};		
		}
	}
}
