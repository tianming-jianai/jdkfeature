package com.itheima.topic1.funinterface;

import java.util.function.Function;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.funinterface
 * @author: 张世罡
 * @CreateTime: 2023/4/3 19:39
 * @Description:
 */
public class Demo08 {
    public static void main(String[] args) {
        test(s -> Integer.valueOf(s));
    }

    public static void test(Function<String, Integer> function) {
        Integer in = function.apply("10");
        System.out.println("in: " + (in + 5));
    }
}
