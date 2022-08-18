package com.zsg.chapter01;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.zsg.chapter01
 * @Author: 张世罡
 * @CreateTime: 2022/8/18 23:28
 * @Description:
 */
public class MyInterfaceImpl implements MyInterface {

    @Override
    public void methodAbstract() {

    }

    @Override
    public void methodDefault() {
        System.out.println("实现类重写了接口中的默认方法");
    }

    public static void main(String[] args) {
        MyInterfaceImpl myInterface = new MyInterfaceImpl();
        myInterface.methodDefault();

        // 接口的私有方法，不能在接口外部调用
//        myInterface.methodPrivate();
    }
}
