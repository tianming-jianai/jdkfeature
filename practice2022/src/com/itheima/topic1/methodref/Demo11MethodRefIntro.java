package com.itheima.topic1.methodref;

import java.util.function.Consumer;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.methodref
 * @author: 张世罡
 * @CreateTime: 2023/4/3 19:58
 * @Description:
 * 方法引用方式：
 * 对象::方法名
 * 类::静态方法
 * 类::普通方法
 * 类::new
 * String[]::new
 */
public class Demo11MethodRefIntro {
    public static void main(String[] args) {
        printMax(Demo11MethodRefIntro::getMax);
    }

    private static void printMax(Consumer<int[]> consumer) {
        int[] arr = {10, 20, 30, 40, 50};
        consumer.accept(arr);
    }

    public static void getMax(int[] arr) {
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        System.out.println(sum);
    }
}
