package com.itheima.topic1.iface;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.iface
 * @author: 张世罡
 * @CreateTime: 2023/4/3 19:00
 * @Description:
 * 接口默认方法定义格式：
 * interface 接口名 {
 *     修饰符 default 返回值类型 方法名(){
 *         代码;
 *     }
 * }
 * 接口默认方法的使用：
 *  1. 实现类直接调用接口默认方法
 *  2. 实现类重写接口默认方法
 *
 */
public class Demo02UserDefaultFunction {
    public static void main(String[] args) {
        BB b = new BB();
        // 方式一：实现类直接调用接口默认方法
        b.test2();

        CC cc = new CC();
        cc.test2();
    }
}

interface AA {
    void test1();

    default void test2() {
        System.out.println("AA test02");
    }
}

class BB implements AA {
    @Override
    public void test1() {
        System.out.println("BB test1");
    }
}

class CC implements AA {
    @Override
    public void test1() {
        System.out.println("CC test1");
    }

    @Override
    public void test2() {
        System.out.println("CC实现类重写接口默认方法");
    }
}
