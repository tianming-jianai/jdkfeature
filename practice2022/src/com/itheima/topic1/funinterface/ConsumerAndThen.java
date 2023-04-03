package com.itheima.topic1.funinterface;

import java.util.function.Consumer;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.funinterface
 * @author: 张世罡
 * @CreateTime: 2023/4/3 19:32
 * @Description:
 */
public class ConsumerAndThen {
    public static void main(String[] args) {
        test(s -> {
            System.out.println(s.toLowerCase());
        }, s -> {
            System.out.println(s.toUpperCase());
        });
    }

    public static void test(Consumer<String> c1, Consumer<String> c2) {
        String str = "Hello world!";
        // c1.accept(str); // 转小写
        // c2.accept(str); // 转大写

        // c1.andThen(c2).accept(str);
        c2.andThen(c1).accept(str);
    }
}

