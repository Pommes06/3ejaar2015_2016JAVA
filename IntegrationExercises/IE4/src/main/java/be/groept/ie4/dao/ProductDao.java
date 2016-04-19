package be.groept.ie4.dao;

import be.groept.ie4.entities.Product;

import java.util.List;

public interface ProductDao {

	List<Product> findProducts(String productName);
}
