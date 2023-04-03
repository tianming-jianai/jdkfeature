package com.itheima.topic1.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.stream
 * @author: 张世罡
 * @CreateTime: 2023/4/3 21:58
 * @Description:
 * Stream的常用方法
 * 终结方法：
 *      返回值类型不再是Stream类型的方法，不再支持链式调用。count/forEach
 * 非终结方法：
 *      返回值类型仍然是Stream类型的方法，支持链式调用。（除了终结方法外，其余方法均为非终结方法）
 *      filter/limit/skip/map/concat
 *
 * Stream注意事项：
 *      1. Stream只能操作一次
 *      2. Stream方法返回的是新的流
 *      3. Stream不调用终结方法，中间的操作不会执行
 */
public class StreamOperator {

    /**
     * forEach
     */
    @Test
    public void testForeach() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子");

        list.stream().forEach(System.out::println);
    }

    /**
     * count
     */
    @Test
    public void testCount() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子");
        long count = list.stream().count();
        System.out.println(count);
    }

    /**
     * filter
     */
    @Test
    public void testFilter() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子");
        list.stream().filter(s -> s.length() == 2).forEach(System.out::println);
    }

    /**
     * limit：对流进行截取，只取前n个
     */
    @Test
    public void testLimit() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子");

        list.stream().limit(3).forEach(System.out::println);
    }

    /**
     * skip：跳过前几个元素；当前长度大于n，则跳过前n个；否则将会得到一个长度为0的空流。
     */
    @Test
    public void testSkip() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子");

        list.stream().skip(2).forEach(System.out::println);
    }

    /**
     * map
     */
    @Test
    public void testMap() {
        Stream<String> stream = Stream.of("11", "22", "33");
        Stream<Integer> result = stream.map(Integer::parseInt);
        result.forEach(s -> System.out.println(s + 10));
    }

    /**
     *
     */
    @Test
    public void testSorted() {
        // 根据元素的自然顺序排序
        // 根据比较器指定的规则排序
        Stream.of(33, 22, 11, 55).sorted().sorted((o1, o2) -> o2 - o1).forEach(System.out::println);
    }

    /**
     *
     */
    @Test
    public void testDistinct() {
        Stream.of(22, 33, 22, 11, 33).distinct().forEach(System.out::println);
    }

    /**
     *
     */
    @Test
    public void testDistinctSelfDefine() {
        Stream.of(new Person("刘德华", 58),
                        new Person("张学友", 56),
                        new Person("张学友", 56),
                        new Person("黎明", 52))
                .distinct().forEach(System.out::println);
    }

    /**
     *
     */
    @Test
    public void testMatch() {
        // boolean b = Stream.of(5, 3, 6, 1).allMatch(e -> e > 0);
        // boolean b = Stream.of(5, 3, 6, 1).anyMatch(e -> e > 5);
        boolean b = Stream.of(5, 3, 6, 1).noneMatch(e -> e > 5);
        System.out.println("b = " + b);
    }

    /**
     *
     */
    @Test
    public void testFind() {
        Optional<Integer> first = Stream.of(5, 3, 6, 1).findFirst();
        System.out.println("first = " + first.get());

        Optional<Integer> any = Stream.of(5, 3, 6, 1).findAny();
        System.out.println("any = " + any.get());
    }

    /**
     *
     */
    @Test
    public void testMax_Min() {
        Optional<Integer> max = Stream.of(5, 3, 6, 1).max((o1, o2) -> o1 - o2);
        System.out.println("max = " + max.get());

        Optional<Integer> min = Stream.of(5, 3, 6, 1).min((o1, o2) -> o1 - o2);
        System.out.println("min = " + min.get());
    }

    /**
     * 将所有数据归纳得到一个数据，可以使用reduce方法
     */
    @Test
    public void testReduce() {
        Optional<Integer> reduce = Stream.of(4, 5, 3, 9).reduce((a, b) -> a + b);
        System.out.println("reduce = " + reduce.get());

        Optional<Integer> reduce2 = Stream.of(4, 5, 3, 9).reduce(Integer::sum);
        System.out.println("reduce2 = " + reduce2.get());

        Optional<Integer> reduce3 = Stream.of(4, 5, 3, 9).reduce((x, y) -> x > y ? x : y);
        System.out.println("max = " + reduce3.get());
    }

    /**
     *
     */
    @Test
    public void testMapReduce() {
        // 求出所有年龄的总和
        Optional<Integer> reduce = Stream.of(new Person("刘德华", 58),
                        new Person("张学友", 56),
                        new Person("郭富城", 54),
                        new Person("黎明", 52))
                .map(p -> p.getAge())
                .reduce(Integer::sum);
        System.out.println(reduce.get());

        // 找出最大年龄
        Integer max = Stream.of(new Person("刘德华", 58),
                        new Person("张学友", 56),
                        new Person("张学友", 56),
                        new Person("黎明", 52))
                .map(p -> p.getAge())
                .reduce(0, (x, y) -> x > y ? x : y);
        System.out.println(max);

        // 统计数字2出现次数
        Integer count = Stream.of(1, 2, 2, 1, 3, 2)
                .map(i -> {
                    if (i == 2) {
                        return 1;
                    } else {
                        return 0;
                    }
                }).reduce(0, Integer::sum);
        System.out.println(count);
    }
}

