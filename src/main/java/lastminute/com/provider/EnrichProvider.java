package lastminute.com.provider;

public interface EnrichProvider<T> {

	void enrich(T type);
}
