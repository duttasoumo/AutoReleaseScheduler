package main.message.mapper;

public interface BaseMapping<T, V> {
	T getMappedBean(V bean1);

}
