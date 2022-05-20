package data;

import java.sql.*;
import java.util.LinkedList;
import entidades.Product;

public interface ProductDAO {

	public LinkedList<Product> list() throws SQLException;
	
	public Product search(Product p) throws SQLException;
	
	public Product newProduct(Product p) throws SQLException;
	
	public void delete(Product p) throws SQLException;
	
	public void update(Product p) throws SQLException;
}
