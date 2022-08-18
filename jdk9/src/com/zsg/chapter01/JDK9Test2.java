package com.zsg.chapter01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.zsg.chapter01
 * @Author: 张世罡
 * @CreateTime: 2022/8/19 0:11
 * @Description:
 */
public class JDK9Test2 {
    public static void main(String[] args) {

        // Jdk9特性八: 集合工厂方法，快速创建只读集合
        // java8写法
        List<String> list = new ArrayList<>();
        list.add("Joe");
        list.add("Bob");
        list.add("Bill");
        list = Collections.unmodifiableList(list);

        // UnsupportedOperationException
//        list.add("app");
        System.out.println(list);
    }
}
