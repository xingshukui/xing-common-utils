package com.xing.utils.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.NoOp;

/**
 * Main
 *
 * @author : xingshukui
 * @date : 2019-09-03 18:02
 * @desc :
 */
@Slf4j
public class Main {

    public static void main(String[] args) {



        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TestProxy.class);
        MethodInterceptor methodInterceptor = (o, method, objects, methodProxy) -> {
            log.info("before");
            Object res = methodProxy.invokeSuper(o, objects);
            log.info("end");
            return res;
        };

        Callback[] callbacks = new Callback[]{methodInterceptor, NoOp.INSTANCE, NoOp.INSTANCE};
        enhancer.setCallbacks(callbacks);
        enhancer.setCallbackFilter(method -> {
            if (method.getName().equals("mth")) {
                return 2;
            }
            return 0;
        });

        Object testProxy = enhancer.create();
        ((TestProxy)testProxy).mth();
        ((TestProxy)testProxy).ath();

    }
}
