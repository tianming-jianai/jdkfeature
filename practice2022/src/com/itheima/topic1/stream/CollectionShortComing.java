package com.itheima.topic1.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.stream
 * @author: 张世罡
 * @CreateTime: 2023/4/3 21:23
 * @Description:
 * Stream API能让我们快速完成许多复杂的操作，如筛选、切片、映射、查找、去除重复、统计、匹配和归纳
 */
public class CollectionShortComing {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰");

        // 拿到所有姓张的
        List<String> zhang = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("张")) {
                zhang.add(name);
            }
        }

        // 拿到姓名长度为3个字符的
        List<String> three = new ArrayList<>();
        for (String name : zhang) {
            if (name.length() == 3) {
                three.add(name);
            }
        }

        for (String name : three) {
            System.out.println(name);
        }

        System.out.println("-------------------");

        // Stream写法
        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(System.out::println);
    }
}
