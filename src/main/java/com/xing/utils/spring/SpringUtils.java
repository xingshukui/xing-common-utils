package com.xing.utils.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author : xingshukui
 * @email : xingshukui@163.com
 * @date : 2018/11/6 4:01 PM
 * @desc :
 */
@Component
public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }


    /**
     * 通过beanName获取bean
     * @param beanName
     * @param <T>
     * @return
     */
    public static <T> T getBean(String beanName) {
        Assert.notNull(beanName, "beanName不能为空");
        return (T) applicationContext.getBean(beanName);
    }
}
