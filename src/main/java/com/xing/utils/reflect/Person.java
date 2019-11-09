package com.xing.utils.reflect;

/**
 * Person
 *
 * @author : xingshukui
 * @date : 2019-09-03 15:18
 * @desc :
 */
public class Person {
    private String name;
    private String address;
    private Integer age;
    private boolean m;


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public boolean isM() {
        return m;
    }

    public void setM(boolean m) {
        this.m = m;
    }
}
