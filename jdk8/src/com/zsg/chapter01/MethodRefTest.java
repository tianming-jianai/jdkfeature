package com.zsg.chapter01;

import com.zsg.pojo.Employee;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.zsg.chapter01
 * @Author: 张世罡
 * @CreateTime: 2022/8/14 2:22
 * @Description: 1. 使用情境：当要传递给lambda体的操作，已经有实现的方法了，可以使用方法引用！
 * 2. 方法引用本质上就是lambda表达式，而lambda表达式作为函数式接口的实例。所以方法引用也是函数式接口的实例。
 * 3. 使用格式：类或对象::方法名
 * 4. 具体分为如下三种情况
 * 对象 :: 非静态方法
 * 类  :: 静态方法
 * 类  :: 非静态方法
 * 5. 方法引用使用要求，要求接口中的抽象方法的形参列表（和）返回值类型 与 方法引用的方法形的参列表（和）返回值类型相同！
 * （针对第一种、第二种）
 * 6. 第三种的参数1作为方法的调用者
 */
public class MethodRefTest {

    /**
     * 情境一： 对象：实例方法
     * Consumer     void accept(T t)
     * PrintStream  void println(T t)
     */
    @Test
    public void test1() {
        Consumer<String> con = str -> System.out.println(str);
        con.accept("北京");

        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("天安门");
    }

    /**
     * Supplier void get()
     * Employee void getName()
     */
    @Test
    public void test2() {
        Employee emp = new Employee(1001, "Tom", 23, 5600);
        Supplier<String> sup1 = () -> emp.getName();
        System.out.println(sup1.get());

        Supplier<String> sup2 = emp::getName;
        System.out.println(sup2.get());
    }

    /**
     * 情境二 类 :: 静态方法
     * Comparator   int compare(T t1, T t2)
     * Integer      int compare(T t1, T t2)
     */
    @Test
    public void test3() {
        Comparator<Integer> com = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(com.compare(1, 2));

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(2, 1));
    }

    /**
     * Function R apply(T t)
     * Math     long round(Double d)
     */
    @Test
    public void test4() {
        Function<Double, Long> func = d -> Math.round(d);
        System.out.println(func.apply(12.3));

        Function<Double, Long> func2 = Math::round;
        System.out.println(func2.apply(12.6));
    }

    /**
     * 情况三 类 :: 实例方法
     * Comparator   int compare(T t1, T t2)
     * String       int t1.compareTo(t2)
     */
    @Test
    public void test5() {
        Comparator<String> comp = (s1, s2) -> s1.compareTo(s2);
        System.out.println(comp.compare("abc", "abd"));

        Comparator<String> comp2 = String::compareTo;
        System.out.println(comp2.compare("abd", "abc"));
    }

    /**
     * BiPredicate  boolean test(T t1, T t2)
     * String       boolean t1.equals(t2)
     */
    @Test
    public void test6() {
        BiPredicate<String, String> pre = (s1, s2) -> s1.equals(s2);
        System.out.println(pre.test("abc", "abd"));

        BiPredicate<String, String> pre2 = String::equals;
        System.out.println(pre2.test("abd", "abd"));
    }

    /**
     * Function R apply(T t)
     * Employee String getName()
     */
    @Test
    public void test7() {
        Employee employee = new Employee();
        employee.setName("Jack");
        Function<Employee, String> func = e -> e.getName();
        System.out.println(func.apply(employee));

        Function<Employee, String> func2 = Employee::getName;
        System.out.println(func2.apply(employee));
    }

}
