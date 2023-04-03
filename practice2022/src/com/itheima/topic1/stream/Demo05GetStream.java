package com.itheima.topic1.stream;

import java.util.stream.Stream;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.stream
 * @author: 张世罡
 * @CreateTime: 2023/4/3 21:46
 * @Description:
 * Stream中的静态方法of获取流
 * 备注：of方法的参数其实是一个可变参数，所以支持数组
 */
public class Demo05GetStream {
    public static void main(String[] args) {
        // Stream中的静态方法：static Stream of(T.. values)
        Stream<String> stream = Stream.of("aa", "bb", "cc", "dd");

        String[] arr = {"aa", "bb", "cc", "dd"};
        Stream<String> stream1 = Stream.of(arr);

        Integer[] arr2 = {11, 22, 33};
        Stream<Integer> stream2 = Stream.of(arr2);
        stream2.filter(c -> c > 20).forEach(System.out::println);

        // 基本数据类型的数组不行
        int[] arr3 = {11, 22, 33};
        Stream<int[]> stream3 = Stream.of(arr3);
    }
}
