package com.xing.utils.thread;

import java.util.concurrent.*;

/**
 * @author : xingshukui
 * @email : xingshukui@163.com
 * @date : 2018/11/6 4:11 PM
 * @desc :
 *
 *  一般线程数设置尽量满足下面公式：N表示cpu核数
 *
 *  T(计算时间) + T(io时间)
 *       ——————————        *  N
 *       T(计算时间)
 *
 * cpu密集型：T(io时间) 约等于0，线程数设置成N
 *
 *
 *
 *
 *
 * 一般用不到下面方法，在spring中最好用bean来配置threadPool，因为默认单例
 *
 *
 */
public class ThreadPoolImpl {

    private static final int availableProcessor = Runtime.getRuntime().availableProcessors();

    /**
     * 线程池线程数量设置：
     *
     * 1.cpu密集型，数量=cpu核数
     * 2.IO密集型：数量=cpu核数 * 2
     *
     */


    public ExecutorService cpuIntensiveThreadPool(int maximumPoolSize, long keepAliveTime,
                                                         TimeUnit unit,
                                                         BlockingQueue<Runnable> workQueue,
                                                         ThreadFactory threadFactory,
                                                         RejectedExecutionHandler handler) {
        return new ThreadPoolExecutor(availableProcessor,
                maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }


    public ExecutorService ioIntensiveThreadPool(int maximumPoolSize, long keepAliveTime,
                                                         TimeUnit unit,
                                                         BlockingQueue<Runnable> workQueue,
                                                         ThreadFactory threadFactory,
                                                         RejectedExecutionHandler handler) {
        return new ThreadPoolExecutor(availableProcessor * 2,
                maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }




}
