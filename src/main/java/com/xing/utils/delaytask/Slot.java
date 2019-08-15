package com.xing.utils.delaytask;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Slot
 *
 * @author : xingshukui
 * @date : 2019-07-26 16:47
 * @desc :
 */
public class Slot {

    private Set<Task> tasks;


    public Slot() {
        this.tasks = new HashSet<>();
    }


    /**
     * 添加新的任务
     * @param orderId
     * @param cycleNum
     */
    public void addTask(Long orderId, Integer cycleNum) {
        this.tasks.add(Task.builder()
                .execCount(0)
                .cycleNum(cycleNum)
                .orderId(orderId)
                .build());
    }


    /**
     * 超时的订单
     * @return
     */
    public Set<Task> getTimeoutTask() {
        Set<Task> timeoutSet =  this.tasks.stream()
                .filter(task -> task.getCycleNum() == 0)
                .collect(Collectors.toSet());
        //全部移除
        if (!timeoutSet.isEmpty()) {
            this.tasks.removeAll(timeoutSet);
        }
        this.tasks.forEach(task -> task.setCycleNum(task.getCycleNum() - 1));
        return timeoutSet;
    }


}
