package com.main.poc.mapstruct.ext;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.main.poc.mapstruct.message.mapper.BaseMapping;
import com.main.poc.mapstruct.message.mapper.Bean01FromBean00Mapping;
import com.main.poc.mapstruct.message.mapper.Bean02FromBean00Mapping;
import com.main.poc.mapstruct.message.mapper.Bean03FromBean00Mapping;

@Component
public class MapperContext {
	@Autowired
	ApplicationContext applicationContext;

	public BaseMapping getMapperBean(String dest, String source) {
		String mapperBean = getMapperBeanName(dest, source);
		BaseMapping mapper = applicationContext.getBean(mapperBean, BaseMapping.class);
		return mapper;
	}

	/**
	 * @param dest
	 * @param source
	 */
	private String getMapperBeanName(String dest, String source) {
		String mapperBean = Strings.EMPTY;
		switch (mapperBeanIdEval(dest, source)) {
		case "Bean01FromBean00Mapping":
			mapperBean = applicationContext.getBeanNamesForType(Bean01FromBean00Mapping.class)[0];
			break;
		case "Bean02FromBean00Mapping":
			mapperBean = applicationContext.getBeanNamesForType(Bean02FromBean00Mapping.class)[0];
			break;
		case "Bean03FromBean00Mapping":
			mapperBean = applicationContext.getBeanNamesForType(Bean03FromBean00Mapping.class)[0];
			break;
		default:
			System.out.println(String.format("No Mapping found from %s To %s", source, dest));
		}
		return mapperBean;
	}

	private String mapperBeanIdEval(String dest, String source) {
		StringBuffer str = new StringBuffer().append(StringUtils.capitalize(dest)).append("From")
				.append(StringUtils.capitalize(source)).append("Mapping");
		return str.toString();
	}
}
