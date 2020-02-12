package main.exc.bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import main.message.mapper.BaseMapping;

public class MapperContext {

	private static String getMapperBean(String destination, String source) {
		String key = mappingBeanIdEvaluator(destination, source);
		String className = "main.message.mapper.Bean01FromBean00Mapping";
		return className;
	}

	private static String mappingBeanIdEvaluator(String destination, String source) {
		StringBuffer str = new StringBuffer().append(destination).append("From").append(source).append("Mapping");
		return str.toString();
	}

	public static BaseMapping getMapperInstance(String destination, String source) throws Exception  {
		BaseMapping mapper = null; 
		try {
		String mapperClass = getMapperBean(destination,source);
		Class<?> clazz;
			clazz = Class.forName(mapperClass);
		Method method = clazz.getMethod("getInstance");
		mapper= (BaseMapping) method.invoke(null, (Object [])null);
		} catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return mapper;
	}
}
