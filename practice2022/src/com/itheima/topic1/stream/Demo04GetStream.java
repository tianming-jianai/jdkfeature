package com.itheima.topic1.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Stream;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.stream
 * @author: 张世罡
 * @CreateTime: 2023/4/3 21:39
 * @Description:
 * 获取Stream流的两种方式
 * 1. 所有Collection集合都可以通过stream默认方法获取流
 * 2. Stream接口的静态方法of可以获取数组对应的流
 */
public class Demo04GetStream {
    public static void main(String[] args) {
        // 集合获取流
        // Collection接口中的方法：default Stream<E> stream()获取流
        List<String> list = new ArrayList<>();

        Stream<String> stream = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream1 = set.stream();

        Vector<String> vector = new Vector<>();
        Stream<String> stream2 = vector.stream();

        Map<String, String> map = new HashMap<>();
        Stream<String> keyStream = map.keySet().stream();
        Stream<String> valueStream = map.values().stream();

        Stream<Map.Entry<String, String>> entryStream = map.entrySet().stream();
    }
}
