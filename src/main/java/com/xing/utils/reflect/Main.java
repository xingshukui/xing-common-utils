package com.xing.utils.reflect;

import com.esotericsoftware.reflectasm.MethodAccess;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Main
 *
 * @author : xingshukui
 * @date : 2019-09-03 15:25
 * @desc :
 */
public class Main {

    public static void main(String[] args) {
        Person p = new Person();
        p.setAddress("address");
        p.setAge(18);
        p.setName("abc");
        p.setM(true);

        Man man = new Man();
        BeanCopyUtils.copyProperties(p, man);

        System.out.println(man.toString());


//        MethodAccess access = MethodAccess.get(Person.class);
//        access.invoke(p, "setName", "张三");
//        System.out.println(p.toString());
//
//        System.out.println(Arrays.toString(access.getMethodNames()));
//        System.out.println(Arrays.toString(Person.class.getMethods()));
//
//        for (Method method : Person.class.getMethods()) {
//            System.out.println(method.getName());
//        }
    }
}
