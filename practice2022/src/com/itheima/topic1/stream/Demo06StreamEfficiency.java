package com.itheima.topic1.stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.stream
 * @author: 张世罡
 * @CreateTime: 2023/4/4 21:51
 * @Description:
 */
public class Demo06StreamEfficiency {
    private static long times = 500000000L;
    private long start;

    @BeforeEach
    public void init() {
        start = System.currentTimeMillis();
    }

    @AfterEach
    public void destroy() {
        long end = System.currentTimeMillis();
        System.out.println("消耗时间：" + (end - start));
    }

    /**
     *
     */
    @Test
    public void testParallelStream() {
        System.out.println("ParallelStream");
        LongStream.range(0, times).parallel().reduce(0, Long::sum);
    }

    /**
     *
     */
    @Test
    public void testSerialStream() {
        System.out.println("SerialStream");
        LongStream.range(0, times).reduce(0, Long::sum);
    }

    /**
     *
     */
    @Test
    public void testFor() {
        System.out.println("For");
        long result = 0L;
        for (long i = 0L; i < times; i++) {
            result += i;
        }
    }
}
