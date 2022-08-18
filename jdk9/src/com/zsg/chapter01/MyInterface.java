package com.zsg.chapter01;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.zsg.chapter01
 * @Author: 张世罡
 * @CreateTime: 2022/8/18 23:25
 * @Description:
 */
public interface MyInterface {

    // 如下三个方法的权限修饰符都是public
    void methodAbstract();

    static void methodStatic() {
        System.out.println("我是接口中的静态方法");
    }

    default void methodDefault(){
        System.out.println("我是接口中的默认方法");
    }

    private void methodPrivate(){
        System.out.println("我是接口中的私有方法");
    }

    public static void main(String[] args) {
        // 接口中的静态方法只能由自己调用
        MyInterface.methodStatic();
    }

}
