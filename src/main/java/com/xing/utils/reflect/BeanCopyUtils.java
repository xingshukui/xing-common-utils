package com.xing.utils.reflect;

import com.esotericsoftware.reflectasm.MethodAccess;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * BeanCopyUtils
 *
 * @author : xingshukui
 * @date : 2019-09-03 15:52
 * @desc :
 */
@Slf4j
public class BeanCopyUtils {


    /**
     *
     * @param target
     * @param destination
     */
    public static void copyProperties(Object target, Object destination) {

        String[][] keyValPair = getKeyValPair(target.getClass());

        MethodAccess targetAccess = MethodAccess.get(target.getClass());
        MethodAccess descAccess = MethodAccess.get(destination.getClass());


        for (int i = 0; i < keyValPair.length; i++) {
            if (keyValPair[i][0] == null) {
                break;
            }
            try {
                Object val = targetAccess.invoke(target, keyValPair[i][0]);
                if (val == null) {
                    continue;
                }
                descAccess.invoke(destination, keyValPair[i][1], val);
            } catch (Exception e) {
                log.warn("setting property exception. setter method name=" + keyValPair[i][1] + " getter method name=" + keyValPair[i][0]);
            }

        }

    }


    /**
     *
     * @param target
     * @return String[][]
     */
    private static String[][] getKeyValPair(Class<?> target) {
        Method[] targetMethod = target.getMethods();

        //二维数组，，{{getXxx,setXxx},{},{}...}
        String[][] res = new String[targetMethod.length][2];
        int i = 0;
        for (Method method : targetMethod) {
            String methodName = method.getName();
            if (methodName.startsWith("get")) {
                String start = "set" + methodName.substring(3);
                res[i][0] = methodName;
                res[i][1] = start;
                i++;
            }else if (methodName.startsWith("is")){
                String start = "set" + methodName.substring(2);
                res[i][0] = methodName;
                res[i][1] = start;
                i++;
            }
        }
        return res;
    }


}
