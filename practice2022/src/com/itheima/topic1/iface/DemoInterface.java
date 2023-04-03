package com.itheima.topic1.iface;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.iface
 * @author: 张世罡
 * @CreateTime: 2023/4/3 18:51
 * @Description: 接口引入默认方法的背景
 */
public class DemoInterface {

}

interface Demo{
    // 静态常量
    // 抽象方法
    // 默认方法
    // 静态方法
}

interface A{
    void test1();
    // 接口新增抽象方法，所有实现类都必须重写这个接口，非常不利于解扣子的扩展
    void test2();
}

class B implements A{
    @Override
    public void test1() {

    }
    // 接口新增抽象方法，所有实现类都去重写这个方法
    @Override
    public void test2() {

    }
}

class C implements A{
    @Override
    public void test1() {

    }

    // 接口新增抽象方法，所有实现类都需要去重写这个方法
    @Override
    public void test2() {

    }
}
