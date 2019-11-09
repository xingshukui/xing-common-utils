package com.xing.utils.test;

import com.google.common.base.Strings;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Test
 *
 * @author : xingshukui
 * @date : 2019-09-24 17:05
 * @desc :
 */
public class Test {

    public static void main(String[] args) {
//        ArrayDeque<String> deque = new ArrayDeque<>(10);
//        deque.add("a");
//        System.out.println(deque);

        String no = "6333 2839 9388 3243 102";
        String no1 = "6333283993883243";

        String pattern = "(?!^)";

        Pattern str = Pattern.compile(pattern);
        Matcher m = str.matcher(no1);
        System.out.println(m.matches());






//        System.out.println(Arrays.toString(no1.split("(?!^)")));
//        System.out.println(no.replaceAll("\\s", ""));
        StringBuilder r = new StringBuilder(String.join("-", no.replaceAll("\\s", "").split("(?!^)")));
        System.out.println(r);
//        System.out.println(String.join(" ", no.replaceAll("\\s", "").split("(?!^)")));

        int j, i = 1;
        while ((j = (8 * i - 1)) < r.length()) {
            r.replace(j, j+1, " ");
            i++;
        }

        System.out.println(r.toString().replace("-", ""));



    }
}
