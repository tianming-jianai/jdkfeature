package com.zsg.chapter01;

import java.util.Comparator;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.zsg.chapter01
 * @Author: 张世罡
 * @CreateTime: 2022/8/14 0:52
 * @Description:
 */
public class LambdaTest {
    public static void main(String[] args) {
        // lambda表达式
        Runnable r = () -> System.out.println("我爱北京天安门！");
        r.run();

        Comparator<Integer> comp = (c1, c2) -> Integer.compare(c1, c2);
        int res = comp.compare(1, 1);
        System.out.println(res);

        // 方法引用
        Comparator<Integer> comp2 = Integer::compare;
        System.out.println(comp2.compare(1, 2));
    }
}
