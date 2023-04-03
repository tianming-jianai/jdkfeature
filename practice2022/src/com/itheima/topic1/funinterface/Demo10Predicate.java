package com.itheima.topic1.funinterface;

import java.util.function.Predicate;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.funinterface
 * @author: 张世罡
 * @CreateTime: 2023/4/3 19:43
 * @Description:
 */
public class Demo10Predicate {
    public static void main(String[] args) {
        test(s -> s.length() > 3, "迪丽热巴");
    }

    public static void test(Predicate<String> predicate, String str) {
        boolean veryLong = predicate.test(str);
        System.out.println("名字很长吗？" + veryLong);
    }
}
