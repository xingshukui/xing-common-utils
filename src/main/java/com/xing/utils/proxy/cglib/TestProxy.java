package com.xing.utils.proxy.cglib;

import lombok.extern.slf4j.Slf4j;

/**
 * TestProxy
 *
 * @author : xingshukui
 * @date : 2019-09-03 18:01
 * @desc :
 */
@Slf4j
public class TestProxy {



    public void mth() {
        log.info("method exec");
    }

    public void ath() {
        log.info("method ath exec");
    }
}
