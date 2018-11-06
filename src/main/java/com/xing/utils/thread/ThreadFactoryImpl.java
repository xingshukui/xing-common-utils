package com.xing.utils.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : xingshukui
 * @email : xingshukui@163.com
 * @date : 2018/11/6 4:01 PM
 * @desc :
 */
public class ThreadFactoryImpl implements ThreadFactory {

    private final String PRIFIX_NAME;
    private final AtomicInteger threadNumber = new AtomicInteger(1);



    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, PRIFIX_NAME + threadNumber.getAndIncrement());
        if (t.isDaemon())
            t.setDaemon(false);
        if (t.getPriority() != Thread.NORM_PRIORITY)
            t.setPriority(Thread.NORM_PRIORITY);
        return t;
    }


    public ThreadFactoryImpl(String PRIFIX_NAME) {
        this.PRIFIX_NAME = PRIFIX_NAME;
    }
}
