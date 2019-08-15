package com.xing.utils.delaytask;


import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * DelayTask
 *
 * @author : xingshukui
 * @date : 2019-07-28 10:27
 * @desc :
 */
public class DelayTaskQueue {



    /**
     * 默认slot数量
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 60;

    /**
     * 游标
     */
    private AtomicInteger cursor = new AtomicInteger(0);

    private Slot[] slots;


    /**
     *
     */
    public DelayTaskQueue() {
        this.slots = new Slot[DEFAULT_INITIAL_CAPACITY];
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new CursorForward(this), 0, 1, TimeUnit.SECONDS);
    }



    /**
     * 新订单
     * @param orderId
     * @param expireTime
     */
    public void addOrder(Long orderId, Long expireTime) {
        Long currentTime = System.currentTimeMillis();
        int offset = (int) ((expireTime - currentTime) / 1000);
        int cycleNum = cycleNum(offset);
        int slotIndex = slotIndex(offset);

        //同步防止slot不存在时new了多个
        synchronized (this) {
            Slot slot;
            if ((slot = this.slots[slotIndex]) == null) {
                slot = new Slot();
                this.slots[slotIndex] = slot;
            }
            System.out.println("添加订单id 【" + orderId + "】 到待取消列表的索引位置：" +
                    "【" + slotIndex + "】 ，执行圈数：【"+ cycleNum + "】， 当前游标：【" + currentCursor() + "】");
            slot.addTask(orderId, cycleNum);
        }


    }


    /**
     * 计算圈数
     * @param offset
     * @return
     */
    private int cycleNum(int offset) {
        return (offset + this.cursor.get() - DEFAULT_INITIAL_CAPACITY) / DEFAULT_INITIAL_CAPACITY;
    }

    /**
     * 计算偏移量offset的slot 位置
     * @param offset
     * @return
     */
    private int slotIndex(int offset) {
        return (offset + this.cursor.get()) % DEFAULT_INITIAL_CAPACITY;
    }

    /**
     * 获取当前游标
     * @return
     */
    private int currentCursor() {
        return this.cursor.get();
    }

    /**
     * 下一个游标位置
     * @return
     */
    private int nextCursor() {
        return slotIndex(1);
    }

    /**
     * 游标向前移动一位
     */
    private void cursorForward() {
        this.cursor.set(nextCursor());
    }


    /**
     * 游标移动
     */
    class CursorForward implements Runnable {
        private DelayTaskQueue delayTaskQueue;
        private ExecutorService executorService = Executors.newFixedThreadPool(1);

        CursorForward(DelayTaskQueue delayTaskQueue) {
            this.delayTaskQueue = delayTaskQueue;
        }

        @Override
        public void run() {
            int cursor = delayTaskQueue.currentCursor();
            delayTaskQueue.cursorForward();
            executorService.submit(new OrderCancel(delayTaskQueue.slots[cursor]));
        }
    }


    /**
     * 订单取消
     */
    class OrderCancel implements Runnable {
        private Slot slot;

        OrderCancel(Slot slot) {
            this.slot = slot;
        }

        @Override
        public void run() {
            Set<Task> tasks = slot.getTimeoutTask();
            if (tasks.isEmpty()) {
                return;
            }
            tasks.forEach(task -> {
                //todo 订单取消
                Long orderId = task.getOrderId();
                System.out.println("订单id 【" + orderId + "】 超时取消");
            });
        }
    }

}
