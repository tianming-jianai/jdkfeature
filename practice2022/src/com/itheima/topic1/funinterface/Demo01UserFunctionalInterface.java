package com.itheima.topic1.funinterface;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.funinterface
 * @author: 张世罡
 * @CreateTime: 2023/4/3 19:16
 * @Description:
 */
public class Demo01UserFunctionalInterface {
    public static void main(String[] args) {
        method(arr -> {
            int sum = 0;
            for (int n : arr) {
                sum += n;
            }
            return sum;
        });
    }

    public static void method(Operator op) {
        int[] arr = {1, 2, 3, 4};
        int sum = op.getSum(arr);
        System.out.println("sum = " + sum);
    }
}

@FunctionalInterface
interface Operator {
    int getSum(int[] arr);
}