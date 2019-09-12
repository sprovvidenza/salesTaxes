package lastminute.com.service;

import java.util.List;

public interface CartService<T,E> {

	T getCart(List<E> products);
}
