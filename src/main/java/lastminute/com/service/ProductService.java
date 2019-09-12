package lastminute.com.service;

import lastminute.com.model.Product;

import java.util.List;

public interface ProductService<T> {

	List<T> getProducts(List<String> items);
}
