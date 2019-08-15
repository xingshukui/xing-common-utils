package com.xing.utils.delaytask;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Task
 *
 * @author : xingshukui
 * @date : 2019-07-26 11:51
 * @desc :
 */
@Data
@Builder
@ToString
public class Task implements Serializable {
    //触发执行时的圈数：当cousor第几圈扫描到这个Slot时，执行任务
    private Integer cycleNum;
    //执行次数，可以规定n次失败之后做某些操作
    private Integer execCount;
    //业务主键
    private Long orderId;


    public Task(Integer cycleNum, Integer execCount, Long orderId) {
        this.cycleNum = cycleNum;
        this.execCount = execCount;
        this.orderId = orderId;
    }

    public Task(Integer cycleNum, Long orderId) {
        this.cycleNum = cycleNum;
        this.execCount = 0;
        this.orderId = orderId;
    }
}
