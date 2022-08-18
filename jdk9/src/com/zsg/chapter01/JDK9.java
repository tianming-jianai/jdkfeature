package com.zsg.chapter01;

import com.zsg.pojo.Person;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.zsg.chapter03
 * @Author: 张世罡
 * @CreateTime: 2022/8/18 22:39
 * @Description: 模块化系统 ☆☆☆
 * JShell命令 ☆☆☆
 * 多版本兼容jar包
 * ----------
 * 接口的私有方法
 * 钻石操作符的使用升级
 * 语法改进：try语句
 * ----------
 * String存储结构变更
 * 便利的集合特性：of()
 * 增强的Stream API
 * 全新的HTTP客户端API
 * Deprecated的相关API
 * ----------
 * javadoc的HTML5支持
 * javascript引擎升级：Nashorn
 * java的动态编译器
 */
public class JDK9 {

    public static void main(String[] args) throws InterruptedException {
        Person p = new Person("Tom", 18);
        System.out.println(p);

        // Jdk9特性五：钻石操作符的升级
        // 钻石操作符与匿名内部类在java8中不能共存
//        Comparator<Object> comparator = new Comparator<Object>() {
        // 在java9中可以
        Comparator<Object> comparator = new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        // java7中的新特性：类型推断
        List<String> list = new ArrayList<>();

        // Jdk9特性六:try操作升级
        // java8中，可以实现资源自动关闭
        // 但是要求执行后必须关闭的所有资源必须在try子句中初始化，否则编译不通过
//        try (InputStreamReader reader = new InputStreamReader(System.in)) {
//            char[] buf = new char[20];
//            int len;
//            if ((len = reader.read(buf)) != -1) {
//                String str = new String(buf, 0, len);
//                System.out.println(str);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // java9 中资源关闭操作：需要自动关闭的资源的实例化可以放在try的一对小括号外。
        // 此时的资源属性是常量，声明为final的，不可修改
        InputStreamReader reader2 = new InputStreamReader(System.in);
        try (reader2) {
            char[] buf = new char[20];
            int len;
            if ((len = reader2.read(buf)) != -1) {
                String str = new String(buf, 0, len);
                System.out.println(str);
            }
//            reader2 = null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Jdk9特性七: String存储结构变更
        // String 再也不用char[] 来存储啦，改成byte[]加上编码标记，节约了一些空间
        // StringBuffer 和 StringBuilder  HotSpot VM 都有相应变化
        new String();

    }
}
