package com.main.poc.mapstruct.ext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.main.poc.mapstruct.message.mapper.BaseMapping;

@Component
public class MapperContext {
	@Autowired
	ApplicationContext applicationContext;

	public BaseMapping getMapperBean(String dest, String source) {
		String mapperBean = mapperBeanIdEval(dest, source);
		BaseMapping mapper = applicationContext.getBean(mapperBean, BaseMapping.class);
		return mapper;
	}


	private String mapperBeanIdEval(String dest, String source) {
		StringBuffer str = new StringBuffer().append(StringUtils.uncapitalize(dest)).append("From")
				.append(StringUtils.capitalize(source)).append("Mapping").append("Impl");
		return str.toString();
	}
}
