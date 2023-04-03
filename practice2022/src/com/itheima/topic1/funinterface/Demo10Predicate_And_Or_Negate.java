package com.itheima.topic1.funinterface;

import java.util.function.Predicate;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.funinterface
 * @author: 张世罡
 * @CreateTime: 2023/4/3 19:47
 * @Description:
 */
public class Demo10Predicate_And_Or_Negate {
    public static void main(String[] args) {
        test(s -> s.contains("H"), s -> s.contains("w"));
    }

    public static void test(Predicate<String> p1, Predicate<String> p2) {
        String str = "Hello world";
        boolean b1 = p1.test(str);
        boolean b2 = p2.test(str);

        // and
        // boolean test = p1.and(p2).test(str);
        // if (test) {
        //     System.out.println("既包含H,也包含w");
        // }

        // or
        // boolean test = p1.or(p2).test(str);
        // if(test){
        //     System.out.println("有H，或者W");
        // }

        // negate
        boolean test = p1.negate().test(str);
        if (test) {
            System.out.println("没有H");
        }
    }
}
