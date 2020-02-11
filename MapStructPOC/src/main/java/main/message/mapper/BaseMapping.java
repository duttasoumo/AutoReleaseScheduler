package main.message.mapper;

public interface BaseMapping<T, V> {
	public T getMappedBean(V bean);
}
