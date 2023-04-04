package com.itheima.topic1.stream;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.stream
 * @author: 张世罡
 * @CreateTime: 2023/4/4 22:30
 * @Description:
 * 1. parallelStream线程不安全
 * 2. parallelStream适用的场景是CPU密集型的，只是做到别浪费CPU，假如本身电脑CPU的负载很大，那还到处用并行流，那并不能起到作用
 * 3. I/O密集型 磁盘、网络消耗较少CPU资源，并行流中不适用I/O密集型操作，就比如适用并行流进行大批量的消息推送，涉及到了大量I/O，使用并行流反而满了很多
 * 4. 使用并行流的时候是无法保证元素的顺序的，也就是即时你使用了同步集合也只能保证元素都正确但无法保证其中的顺序
 */
public class Demo07ForkJoin {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        SumRecursiveTask task = new SumRecursiveTask(1, 10000L);
        Long result = pool.invoke(task);
        System.out.println("result = " + result);
        long end = System.currentTimeMillis();
        System.out.println("消耗的时间为：" + (end - start));
    }
}

class SumRecursiveTask extends RecursiveTask<Long> {

    private static final long THRESHOLD = 3000L;
    private final long start;
    private final long end;

    public SumRecursiveTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THRESHOLD) {
            // 任务不再拆分了，可以计算了
            long sum = 0;
            for (long i = 0; i <= end; i++) {
                sum += i;
            }
            System.out.println("计算：" + start + " -> " + end + "，结果为：" + sum);
            return sum;
        } else {
            // 数量大于预定的数量，任务还需要再拆分
            long middle = (start + end) / 2;
            System.out.println("拆分：左边 " + start + " -> " + middle + "，右边 " + (middle + 1) + " -> " + end);

            SumRecursiveTask left = new SumRecursiveTask(start, middle);
            left.fork();
            SumRecursiveTask right = new SumRecursiveTask(middle + 1, end);
            right.fork();
            return left.join() + right.join();
        }
    }
}