package com.itheima.topic1.funinterface;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.funinterface
 * @author: 张世罡
 * @CreateTime: 2023/4/3 19:23
 * @Description: 供给 对外提供一个符合泛型类型的对象数据
 * 供给型接口：通过Supplier接口中的get方法可以得到一个值，无参有返回值的接口
 */
public class Demo05Supplier {
    public static void main(String[] args) {
        printMax(() -> {
            int[] arr = {10, 20, 100, 30, 40, 50};
            Arrays.sort(arr);
            return arr[arr.length - 1];
        });
    }

    private static void printMax(Supplier<Integer> supplier) {
        Integer max = supplier.get();
        System.out.println("max = " + max);
    }
}
