package com.xing.utils.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;

/**
 * CustomConverter
 *
 * @author : xingshukui
 * @date : 2019/7/1 8:50 PM
 * @desc :
 *
 * 请求参数中的空格问题
 *
 */
@Component
public class CustomConverter {


    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @PostConstruct
    public void addConversionConfig(){
        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) requestMappingHandlerAdapter.getWebBindingInitializer();
        if(initializer != null && initializer.getConversionService()!=null){
            GenericConversionService genericConversionService =(GenericConversionService) initializer.getConversionService();
            genericConversionService.addConverter(new StringConverter());
        }
    }


    class StringConverter implements Converter<String, String> {

        @Override
        public String convert(String s) {
            if (StringUtils.isEmpty(s)) {
                return s.trim();
            }
            return s;
        }
    }


}
