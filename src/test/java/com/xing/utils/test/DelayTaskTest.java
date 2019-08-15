package com.xing.utils.test;

import com.xing.utils.delaytask.DelayTaskQueue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Main
 *
 * @author : xingshukui
 * @date : 2019-08-14 20:22
 * @desc :
 */
public class DelayTaskTest {

    public static void main(String[] args) {
        DelayTaskQueue delayTaskQueue = new DelayTaskQueue();
        AtomicInteger id = new AtomicInteger(1);

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 20; j++) {
                        try {
                            TimeUnit.SECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        delayTaskQueue.addOrder((long)id.incrementAndGet(), System.currentTimeMillis() + 20 * 1000);
                    }
                }
            }).start();
        }
    }
}
