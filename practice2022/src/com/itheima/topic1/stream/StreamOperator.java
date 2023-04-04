package com.itheima.topic1.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
 *
 * 收集Stream流中的结果
 *      1. 到集合中：Collectors.toList()、Collectors.toSet()、Collectors.toCollection()
 *      2. 到数组中：toArray()、toArray(int[]::new)
 * 聚合计算：
 *      Collectors.maxBy、Collectors.minBy、Collectors.counting、Collectors.summingInt、Collectors.averagingInt
 * 分组：Collectors.groupingBy
 * 分区：Collectors.partitionBy
 * 拼接：Collectors.joining
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

    /**
     * 将Stream流中的Integer转换成int类型
     */
    @Test
    public void testMapToInt() {
        // Integer占用的内存比int多，在stream流操作中会自动装箱和拆箱
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5});
        // Integer reduce = stream.filter(i -> i > 3).reduce(0, Integer::sum);
        // System.out.println(reduce);

        int reduce = stream.mapToInt(Integer::intValue).filter(i -> i > 3).reduce(0, Integer::sum);
        System.out.println(reduce);

        // 将IntStream转换为Stream<Integer>
        IntStream intStream = IntStream.rangeClosed(1, 10);
        Stream<Integer> boxed = intStream.boxed();
        boxed.forEach(s -> System.out.println(s.getClass() + ", " + s));
    }

    /**
     * 如果有两个流，希望合并成为一个流，那么可以使用Stream接口的静态方法concat
     */
    @Test
    public void testConcat() {
        Stream<String> streamA = Stream.of("张三");
        Stream<String> streamB = Stream.of("李四");
        Stream<String> result = Stream.concat(streamA, streamB);
        result.forEach(System.out::println);
    }

    /**
     * 综合案例
     */
    @Test
    public void testComprehensiveCase() {
        List<String> one = List.of("迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子", "洪七公");
        List<String> two = List.of("古力娜扎", "张无忌", "张三丰", "赵丽颖", "张二狗", "张天爱", "张三");

        Stream<String> one3 = one.stream().filter(s -> s.length() >= 3).limit(3);
        Stream<String> twoZhang = two.stream().filter(s -> s.startsWith("张")).skip(2);
        Stream<String> concat = Stream.concat(one3, twoZhang);
        concat.map(Person::new).forEach(System.out::println);
    }

    /**
     * Stream流中的结果到集合中
     */
    @Test
    public void testStreamToCollection() {
        Stream<String> stream = Stream.of("aa", "bb", "cc");
        // List<String> list = stream.collect(Collectors.toList());
        // Set<String> set = stream.collect(Collectors.toSet());

        // ArrayList<String> arrayList = stream.collect(Collectors.toCollection(ArrayList::new));
        HashSet<String> hashSet = stream.collect(Collectors.toCollection(HashSet::new));
    }

    /**
     * Stream流中的结果到数组中
     */
    @Test
    public void testStreamToArray() {
        Stream<String> stream = Stream.of("aa", "bb", "cc");
        // Object[] objects = stream.toArray();
        // for (Object object : objects) {
        //     System.out.println(object);
        // }

        String[] strings = stream.toArray(String[]::new);
        for (String str : strings) {
            System.out.println(str);
        }
    }

    /**
     * 对流中数据进行聚合计算
     * 当我们使用Stream流处理数据后，可以像数据库的聚合函数一样对某个字段进行操作。比如获取最大值，获取最小值，求总和
     */
    @Test
    public void testStreamToOther() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 58, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 99),
                new Student("柳岩", 52, 77));
        // 获取最大值
        // Optional<Student> collect = studentStream.collect(Collectors.maxBy((o1, o2) -> o1.getScore() - o2.getScore()));
        // System.out.println(collect.get());

        // 获取最小值
        // Optional<Student> collect1 = studentStream.collect(Collectors.minBy((o1, o2) -> o1.getScore() - o2.getScore()));
        // System.out.println(collect1.get());

        // 求总和
        // Integer sumAge = studentStream.collect(Collectors.summingInt(s -> s.getAge()));
        // System.out.println(sumAge);

        // 平均值
        // Double avgScore = studentStream.collect(Collectors.averagingInt(s -> s.getScore()));
        // System.out.println(avgScore);

        // 统计数量
        Long count = studentStream.collect(Collectors.counting());
        System.out.println(count);
    }

    /**
     * 对流中数据进行分组
     */
    @Test
    public void testGroup() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 58, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 99),
                new Student("柳岩", 52, 50));
        // Map<Integer, List<Student>> listMap = studentStream.collect(Collectors.groupingBy(Student::getAge));
        // listMap.forEach((k, v) -> System.out.println(k + " ：： " + v));

        // 将分数大于60的分为一组，小于60分成另一组
        Map<String, List<Student>> listMap = studentStream.collect(Collectors.groupingBy(s -> {
            if (s.getScore() > 60) {
                return "及格";
            } else {
                return "不及格";
            }
        }));
        listMap.forEach((k, v) -> System.out.println(k + " ：： " + v));
    }

    /**
     * 对流中数据间多级分组
     */
    @Test
    public void testCustomGroup() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 58, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 99),
                new Student("柳岩", 52, 50));
        Map<Integer, Map<String, List<Student>>> map = studentStream.collect(Collectors.groupingBy(s -> s.getAge(), Collectors.groupingBy(s -> {
            if (s.getScore() >= 90) {
                return "优秀";
            } else if (s.getScore() >= 80 && s.getScore() < 90) {
                return "良好";
            } else if (s.getScore() >= 70 && s.getScore() < 80) {
                return "及格";
            } else {
                return "不及格";
            }
        })));

        map.forEach((k, v) -> {
            System.out.println(k + " == " + v);
        });
    }

    /**
     * 对流中数据进行分区
     */
    @Test
    public void testPartition() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 58, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 99),
                new Student("柳岩", 52, 50));
        Map<Boolean, List<Student>> map = studentStream.collect(Collectors.partitioningBy(s -> s.getScore() > 90));
        map.forEach((k, v) -> {
            System.out.println(k + " == " + v);
        });
    }

    /**
     * 对流中数据进行拼接
     */
    @Test
    public void testJoining() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 58, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 56, 99),
                new Student("柳岩", 52, 50));
        String collect = studentStream.map(Student::getName).collect(Collectors.joining(">_<", "^_^", "^v^"));
        System.out.println(collect);
    }
}

