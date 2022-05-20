package ui;

import java.sql.SQLException;
import java.util.*;

import data.ProductDAOJDBC;
import entidades.Product;

public class Menu {
	
	Scanner s = null;
	ProductDAOJDBC pDao = new ProductDAOJDBC();
	
	public void start() {
		s = new Scanner(System.in);
		String command;
		do {
			command = getCommand();
			executeCommand(command);
			System.out.println();
		}while(!command.equalsIgnoreCase("exit"));
	}

	private void executeCommand(String command) {
		switch(command) {
		case "list":
			System.out.println("LISTA DE PRODUCTOS");
			System.out.println("------------------");
			list();
			break;
		case "search":
			System.out.println("BUSQUEDA DE PRODUCTO");
			System.out.println("--------------------");
			search();
			break;
		case "new":
			System.out.println("CREACION DE PRODUCTO");
			System.out.println("--------------------");
			newProducto();
			break;
		case "delete":
			System.out.println("BORRAR PRODUCTO");
			System.out.println("---------------");
			delete();
			break;
		case "update":
			System.out.println("ACTUALIZAR PRODUCTO");
			System.out.println("---------------");
			update();
			break;
		}
	}
	
	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("list\t\tlistar todos los productos");
		System.out.println("search\t\tmostrar los datos completos de un producto");
		System.out.println("new\t\tagregar un nuevo productos");
		System.out.println("delete\t\teliminar un producto");
		System.out.println("update\t\tmodificar un producto");
		System.out.println("exit\t\tsalir");
		System.out.println();
		System.out.println("comando:");
		return s.nextLine();
	}
	
	private void list() {
		try {
			LinkedList<Product> productos = pDao.list();
			for(Product p: productos) {
				System.out.println("id: " + String.valueOf(p.getId()) + " nombre: " + p.getName() + " precio: " + String.valueOf(p.getPrice()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void search() {
		System.out.println("Ingrese el id del producto a buscar:");
		try {
			Product p = pDao.search(new Product(Integer.parseInt(s.nextLine())));
			if(p != null) {
				System.out.println(p);
			} else {
				System.out.println("No se encontro ningun producto con ese id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void newProducto() {
		Product p = new Product();
		System.out.println("Ingrese el nombre del producto: ");
		p.setName(s.nextLine());
		System.out.println("Ingrese la descripcion del producto: ");
		p.setDescription(s.nextLine());;
		System.out.println("Ingrese el precio: ");
		p.setPrice(Double.parseDouble(s.nextLine()));;
		System.out.println("Ingrese el stock disponible en este momento: ");
		p.setStock(Integer.parseInt(s.nextLine()));;
		System.out.println("Ingrese 's' si el producto incluye el envio, de lo contrario, ingrese 'n'");
		char q = Character.toLowerCase(s.nextLine().charAt(0));
		verificarSON(q);
		if(q == 's') p.setShippingIncluded(true);
		else p.setShippingIncluded(false);
		try {
			System.out.println(pDao.newProduct(p).getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void delete() {
		System.out.println("Ingrese el id del producto a eliminar:");
		try {
			Product p = pDao.search(new Product(Integer.parseInt(s.nextLine())));
			if(p != null) {
				pDao.delete(p);
				System.out.println("Producto eliminado");
			} else {
				System.out.println("No se encontro ningun producto con ese id");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void update() {
		System.out.println("Ingrese el id del producto a actualizar:");
		try {
			Product p = pDao.search(new Product(Integer.parseInt(s.nextLine())));
			if(p != null) {
				System.out.println(p);
				System.out.println("Ingrese 's' si desea modificar el nombre, de lo contrario, ingrese 'n'");
				char q = Character.toLowerCase(s.nextLine().charAt(0));
				verificarSON(q);
				if(q == 's') {
					System.out.println("Ingrese el nuevo nombre del producto: ");
					p.setName(s.nextLine());
				}
				System.out.println("Ingrese 's' si desea modificar la descripcion, de lo contrario, ingrese 'n'");
				q = Character.toLowerCase(s.nextLine().charAt(0));
				verificarSON(q);
				if(q == 's') {
					System.out.println("Ingrese la nueva descripcion del producto: ");
					p.setDescription(s.nextLine());
				}
				System.out.println("Ingrese 's' si desea modificar el precio, de lo contrario, ingrese 'n'");
				q = Character.toLowerCase(s.nextLine().charAt(0));
				verificarSON(q);
				if(q == 's') {
					System.out.println("Ingrese el nuevo precio del producto: ");
					p.setPrice(Double.parseDouble(s.nextLine()));
				}
				System.out.println("Ingrese 's' si desea modificar el stock, de lo contrario, ingrese 'n'");
				q = Character.toLowerCase(s.nextLine().charAt(0));
				verificarSON(q);
				if(q == 's') {
					System.out.println("Ingrese el nuevo stock del producto: ");
					p.setStock(Integer.parseInt(s.nextLine()));
				}
				System.out.println("Ingrese 's' si desea modificar el envio, de lo contrario, ingrese 'n'");
				q = Character.toLowerCase(s.nextLine().charAt(0));
				verificarSON(q);
				if(q == 's') {
					System.out.println("Ingrese 's' si el producto incluye el envio, de lo contrario, ingrese 'n'");
					q = Character.toLowerCase(s.nextLine().charAt(0));
					verificarSON(q);
					if(q == 's') p.setShippingIncluded(true);
					else p.setShippingIncluded(false);
				}
				pDao.update(p);
			} else {
				System.out.println("No se encontro ningun producto con ese id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void verificarSON(char q) {
		while (q != 's' && q != 'n') {
			System.out.println("Ingrese 's' o 'n': ");
			q = Character.toLowerCase(s.nextLine().charAt(0));
		}
	}
}
