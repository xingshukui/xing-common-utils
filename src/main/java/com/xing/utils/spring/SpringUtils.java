package com.xing.utils.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
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


    /**
     *
     * @param beanId 注册的beanId(name)
     * @param className bean的className，
     *                     三种获取方式：1、直接书写，如：com.mvc.entity.User
     *                                   2、User.class.getName
     *                                   3.user.getClass().getName()
     */
    public static void registerBean(String beanId, String className) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(className);
        BeanDefinition beanDefinition = builder.getBeanDefinition();
        BeanDefinitionRegistry beanDefinitionRegistry = (DefaultListableBeanFactory) ((ConfigurableApplicationContext)applicationContext).getBeanFactory();
        beanDefinitionRegistry.registerBeanDefinition(className, beanDefinition);
    }

}
