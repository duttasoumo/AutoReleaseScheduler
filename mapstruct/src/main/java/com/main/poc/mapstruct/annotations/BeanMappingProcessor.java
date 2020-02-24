package com.main.poc.mapstruct.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.main.poc.mapstruct.message.bean.MessageBean;
import com.main.poc.mapstruct.message.bean.RandomBean0;

import CustomException.IllegalMapperAnnotationException;

@Component
public class BeanMappingProcessor {
	@Autowired
	ApplicationContext applicationContext;
	

	public MessageBean generateTargetBean(Object mapper,MessageBean bean) {
		BeanMapping annotation = mapper.getClass().getAnnotation(BeanMapping.class);
		String mapperId=mapper.getClass().getSimpleName();
		MessageBean targetBean=null;
		if (annotation == null) {
			throw new IllegalMapperAnnotationException(
					"Mapper Class with mapperId : " + mapperId + "is not annotated with BeanMapping Annotation");
		}
		String mappingFunction = annotation.mappingFunction();
		try {
			Method mappingMethod = mapper.getClass().getDeclaredMethod(mappingFunction, RandomBean0.class);
			 targetBean = (MessageBean) mappingMethod.invoke(mapper, bean);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			throw new IllegalMapperAnnotationException(
					"Errorneous mappingfunction value provided in BeanMapping annotation for mapper id : " + mapperId);
		
		}
		return targetBean;
	}
}