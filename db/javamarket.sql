DROP DATABASE IF EXISTS javamarket;
CREATE DATABASE javamarket;

DROP TABLE IF EXISTS javamarket.product;
CREATE TABLE javamarket.product (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  product_name VARCHAR(30) NOT NULL,
  product_desc VARCHAR(100) NOT NULL,
  price DOUBLE NOT NULL,
  stock INT NOT NULL,
  shippingIncluded BOOLEAN NOT NULL);

INSERT INTO javamarket.product (product_name, product_desc, price, stock, shippingIncluded)
VALUES 	("Cartuchera", "Cartuchera con 2 bolsillos", 1250, 50, true),
		("Carpeta", "Carpeta roja con ganchos", 600, 50, true),
        ("Libreta rayada", "Libreta rayada con 100 hojas", 350, 20, true);

DROP USER IF EXISTS 'usuario1'@'localhost';
CREATE USER 'usuario1'@'localhost' IDENTIFIED BY 'vikingo22';
GRANT SELECT, INSERT, UPDATE, DELETE ON javamarket.* TO 'usuario1'@'localhost';

#EJERCICIO 6B
ALTER TABLE product
ADD COLUMN disabledOn DATE;