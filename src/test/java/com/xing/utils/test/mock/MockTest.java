package com.xing.utils.test.mock;

import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.TypeReference;
import com.github.jsonzou.jmockdata.mocker.BeanMocker;
import com.github.jsonzou.jmockdata.mocker.StringMocker;
import com.xing.utils.entity.mock.TestEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * MockTest
 *
 * @author : xingshukui
 * @date : 2019-11-09 15:14
 * @desc :
 */
@RunWith(JUnit4.class)
public class MockTest {

    @Test
    public void mock() {
        TestEntity mock = JMockData.mock(TestEntity.class);
        System.out.println(mock);

        TestEntity mock1 = JMockData.mock(new TypeReference<TestEntity>(){});
        System.out.println(mock1.toString());
    }
}
