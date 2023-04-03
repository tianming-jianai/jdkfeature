package com.itheima.topic1.lambda;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.lambda
 * @author: 张世罡
 * @CreateTime: 2023/4/3 18:45
 * @Description:
 */
public class Demo5LambdaCondition {
    public static void main(String[] args) {
        test01(() -> {
        });
        Flyable s = new Flyable() {
            @Override
            public void flying() {

            }
        };
        Flyable s2 = () -> {
        };

    }

    public static void test01(Flyable fly) {
        fly.flying();
    }
}
