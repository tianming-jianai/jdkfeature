package com.itheima.topic1.funinterface;

import java.util.function.Consumer;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.funinterface
 * @author: 张世罡
 * @CreateTime: 2023/4/3 19:30
 * @Description:
 */
public class Demo06Consumer {
    public static void main(String[] args) {
        test(s -> {
            System.out.println(s);
        });
    }

    private static void test(Consumer<String> consumer) {
        consumer.accept("Hello world");
    }
}
