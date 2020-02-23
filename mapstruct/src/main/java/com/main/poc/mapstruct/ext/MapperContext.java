package com.main.poc.mapstruct.ext;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.main.poc.mapstruct.annotations.BeanMappingProcessor;
import com.main.poc.mapstruct.message.bean.MessageBean;
import com.main.poc.mapstruct.message.mapper.BaseMapping;
import com.main.poc.mapstruct.query.InterfaceMapper;

import CustomException.MapperNotFounfException;

@Component
public class MapperContext {
	@Autowired
	ApplicationContext applicationContext;
	@Autowired
	BeanMappingProcessor beanMappingProcessor;
	@Autowired
	InterfaceMapper interfaceMapper;

	public MessageBean convert(String dest, String source, MessageBean sourceBean) {
		String mapperId = mapperBeanIdEval(dest, source);
		BaseMapping mapper = applicationContext.getBean(mapperId, BaseMapping.class);
		if (mapper == null) {
			throw new MapperNotFounfException("Mapper Implementation notfound for mapperId =" + mapperId);
		}
		MessageBean targetBean = beanMappingProcessor.generateTargetBean(mapper, sourceBean);
		return targetBean;
	}

	private String mapperBeanIdEval(String target, String source) {
		String mapperId = "";
		try {
			mapperId = interfaceMapper.getMapperId(target, source);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return StringUtils.uncapitalize(mapperId);
	}
}
