package com.itheima.topic1.optional;

import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.Map;
import java.util.Optional;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.optional
 * @author: 张世罡
 * @CreateTime: 2023/4/4 22:50
 * @Description:
 * Optional是一个没有之类的工具类，Optional是一个可以为null的容器对象。它的作用主要就是为了解决避免NULL检查，防止NPE
 *
 * // 基本使用
 * Optional.of(T t) 创建一个Optional实例
 * Optional.empty() 创建一个空的Optional实例
 * Optional.ofNullable(T t) 若t不为null，创建Optional实例，否则创建空实例
 *
 * // 常用方法
 * isPresent() 判断是否包含值，包含返回true，不包含返回false
 * get() 如果Optional有值则将其返回，否则抛出NoSuchElementException
 * orElse(T t) 如果调用对象包含值，返回该值，否则返回参数t
 * orElseGet(Supplier s) 如果调用对象包含值，返回该值，否则返回s获取的值
 * map(Function f) 如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty()
 *
 * Optional是一个可以为null的容器对象。orElse、ifPresent、ifPresentOrELse、map等方法避免对null的判断，写出更优雅的代码
 *
 */
public class OptionalTest {

    /**
     *
     */
    @Test
    public void test01() {
        String userName = "凤姐";
        if (userName != null) {
            System.out.println("用户名：" + userName);
        } else {
            System.out.println("用户名不存在");
        }
    }

    /**
     *
     */
    @Test
    public void test02() {
        Optional<String> userName0 = Optional.of("凤姐");
        // Optional<String> userName1 = Optional.of(null);
        Optional<String> userName2 = Optional.ofNullable(null);

        Optional<Object> userName3 = Optional.empty();
        if (userName0.isPresent()) {
            String userName = userName0.get();
            System.out.println("用户名：" + userName);
        } else {
            System.out.println("用户名不存在");
        }
    }

    /**
     *
     */
    @Test
    public void test03() {
        Optional<String> userName0 = Optional.of("凤姐");
        Optional<String> userName1 = Optional.empty();

        // 存在做什么
        userName0.ifPresent(s -> System.out.println("用户名为：" + s));

        // 存在的做什么，不存在做点什么
        userName1.ifPresentOrElse(System.out::println, () -> System.out.println("文件名不存在"));
    }

    /**
     *
     */
    @Test
    public void test04() {
        Optional<String> userName0 = Optional.of("凤姐");
        Optional<String> userName1 = Optional.empty();

        // 如果调用对象包含值，返回该值，否则返回参数t
        System.out.println("用户名为：" + userName1.orElse("null"));

        // 如果调用对象包含值，返回该值，否则返回参数Supplier得到的值
        String s1 = userName1.orElseGet(() -> "未知用户名");
        System.out.println("s1 = " + s1);
    }

    /**
     *
     */
    @Test
    public void test05() {
        User user1 = new User("Hello World", 18);
        User user2 = new User(null, 18);
        User user3 = null;

        System.out.println(getUpperCaseUserName1(user1));

        System.out.println(getUpperCaseUserName2(Optional.of(user1)));
    }

    private String getUpperCaseUserName1(User u) {
        if (u != null) {
            String name = u.getName();
            if (name != null) {
                return name;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private String getUpperCaseUserName2(Optional<User> uo) {
        return uo.map(User::getName).map(String::toUpperCase).orElse("null");
    }
}
