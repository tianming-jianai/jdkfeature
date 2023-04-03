package com.itheima.topic1.lambda;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.lambda
 * @author: 张世罡
 * @CreateTime: 2023/4/3 17:57
 * @Description:
 */
public class Demo4LambdaImpl {
    public static void main(String[] args) {
        goSwimming(() -> System.out.println("使用匿名内部类实现游泳！"));
    }

    public static void goSwimming(Swimmable swimmable) {
        swimmable.swimming();
    }
}
