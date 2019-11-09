package com.xing.utils.proxy;

/**
 * APerson
 *
 * @author : xingshukui
 * @date : 2019-08-29 17:41
 * @desc :
 */
public class APerson implements Person {

    @Override
    public void move() {
        System.out.println("步行");
    }
}
