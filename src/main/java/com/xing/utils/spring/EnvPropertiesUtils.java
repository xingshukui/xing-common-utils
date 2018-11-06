package com.xing.utils.spring;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author : xingshukui
 * @email : xingshukui@163.com
 * @date : 2018/11/6 4:01 PM
 * @desc :
 */
@Component
public class EnvPropertiesUtils implements EnvironmentAware {

    private static Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        EnvPropertiesUtils.environment = environment;
    }


    /**
     * 通过属性key获取属性值
     * @param key
     * @return
     */
    public static String getPropertiers(String key) {
        Assert.notNull(key, "get property by key error key is null");
        return environment.getProperty(key);
    }
}
