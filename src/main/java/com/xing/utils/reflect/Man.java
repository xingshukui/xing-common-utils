package com.xing.utils.reflect;

/**
 * Man
 *
 * @author : xingshukui
 * @date : 2019-09-03 17:17
 * @desc :
 */
public class Man {
    private String name;

    private Integer age;

    private boolean m;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", m=" + m +
                '}';
    }
}
