package com.itheima.topic1.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.stream
 * @author: 张世罡
 * @CreateTime: 2023/4/4 21:22
 * @Description:
 * parallelStream其实就是一个并行执行的流，它通过ForkJoinPool，可能提高多线程任务的速度
 *
 * 获取并行Stream流的两种方式：
 *      1. 直接获取并行流
 *      2. 将串行流转成并行流
 */
public class ParallelStream {

    /**
     * 目前我们使用的Stream流是串行的，就是在一个线程上运行
     */
    @Test
    public void testSerial() {
        long count = Stream.of(4, 5, 3, 9, 1, 2, 6).filter(s -> {
            System.out.println(Thread.currentThread() + "，s = " + s);
            return true;
        }).count();
        System.out.println(count);
    }

    /**
     *
     */
    @Test
    public void testParallelStream() {
        ArrayList<String> list = new ArrayList<>();
        // 直接获取并行流
        Stream<String> stream = list.parallelStream();

        // 将串行流转换成并行流
        Stream<String> stream1 = list.stream().parallel();
    }

    /**
     * 并行操作代码
     */
    @Test
    public void testParallel() {
        long count = Stream.of(4, 5, 3, 9, 1, 2, 6).parallel().filter(s -> {
            System.out.println(Thread.currentThread() + ", s = " + s);
            return true;
        }).count();
        System.out.println("count = " + count);
    }
}
