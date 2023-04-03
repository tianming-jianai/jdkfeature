package com.itheima.topic1.funinterface;

import java.util.function.Function;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.funinterface
 * @author: 张世罡
 * @CreateTime: 2023/4/3 19:41
 * @Description:
 */
public class Demo09FunctionAndThen {
    public static void main(String[] args) {
        test(s -> Integer.valueOf(s), i -> i * 10);
    }

    public static void test(Function<String, Integer> f1, Function<Integer, Integer> f2) {
        Integer in3 = f1.andThen(f2).apply("66");
        System.out.println("in3 = " + in3);
    }
}
