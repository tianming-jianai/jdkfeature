package com.itheima.topic1.iface;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.iface
 * @author: 张世罡
 * @CreateTime: 2023/4/3 19:08
 * @Description:
 * 接口默认方法和静态方法的区别：
 * 1. 默认方法可以通过实例调用，静态方法通过接口名调用
 * 2. 默认方法可以被继承，实现类可以直接使用接口默认方法，也可以重写接口默认方法
 * 3. 静态方法不能被继承，实现类不能重写接口静态方法，只能使用接口名调用
 *
 * 小结：
 * 默认方法、静态方法 如何选择
 * 如果这个方法需要被实现类继承或重写，使用默认方法，如果接口中的方法不需要被继承就使用静态方法
 */
public class Demo04UserStaticFunction {
    public static void main(String[] args) {
        // 直接使用接口名调用即可：接口名.静态方法名()
        AAA.test1();
    }
}

interface AAA {
    static void test1() {
        System.out.println("AAA 接口的静态方法");
    }
}

class BBB implements AAA {
    /*@Override 静态方法不能重写
    public static void test1(){
        System.out.println("AAA 接口的静态方法2");
    }*/
}
