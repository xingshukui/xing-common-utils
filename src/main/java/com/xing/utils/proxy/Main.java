package com.xing.utils.proxy;

import java.lang.reflect.*;

/**
 * Main
 *
 * @author : xingshukui
 * @date : 2019-08-29 17:43
 * @desc :
 */
public class Main {


    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        APerson aPerson = new APerson();
        Person proxy = (Person) getProxy(aPerson);
//        Person proxy = (Person) getProxy2(aPerson);
        proxy.move();
//        System.out.println(proxy.toString());
    }



    private static Object getProxy(final Object target) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class proxyClazz = Proxy.getProxyClass(target.getClass().getClassLoader(), target.getClass().getInterfaces());
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
        return constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("method name = " + method.getName());
                    return method.invoke(target, args);
            }
        });
    }

    private static Object getProxy2(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("method name = " + method.getName());
                return method.invoke(target, args);
            }
        });
    }
}
