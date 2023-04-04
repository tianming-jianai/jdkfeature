package com.itheima.topic1.stream;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.stream
 * @author: 张世罡
 * @CreateTime: 2023/4/4 22:02
 * @Description:
 */
public class ParallelTheadSafeTest {
    /**
     * 我们明明往集合中添加了1000个元素，而实际上只有903个元素
     * 解决方法：加锁、使用线程安全的集合类或者调用Stream的toArray()、collect()操作就是满足线程安全的了。
     */
    @Test
    public void parallelStreamNotice() {
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        List<Integer> newList = new CopyOnWriteArrayList<>();
        // 使用并行流往集合中添加数据
        list.parallelStream().forEach(s -> newList.add(s));
        System.out.println("newList = " + newList.size());
        // newList = 968
    }
}
