package com.zsg.chapter01;

import com.zsg.pojo.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.zsg.chapter01
 * @Author: 张世罡
 * @CreateTime: 2022/8/14 16:36
 * @Description: 1. 构造器引用
 * 和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致抽象方法的返回值类型即为构造器所属的类的类型
 * 2. 数组引用
 * 大家可以把数组看做是一个特殊的类，则写法与构造器引用一致。
 */
public class ConstructorRefTest {

    /**
     * 构造器引用
     * Supplier T get()
     * Employee Employee()
     */
    @Test
    public void test1() {
        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(sup.get());

        Supplier<Employee> sup2 = () -> new Employee();
        System.out.println(sup2.get());

        Supplier<Employee> sup3 = Employee::new;
        System.out.println(sup3.get());
    }

    /**
     * Function R apply(T t)
     */
    @Test
    public void test2() {
        Function<Integer, Employee> func = id -> new Employee(id);
        Employee apply = func.apply(1001);
        System.out.println(apply);
        Function<Integer, Employee> func2 = Employee::new;
        Employee apply2 = func2.apply(1002);
        System.out.println(apply2);
    }

    /**
     * BiFunction R apply(T t, U u)
     */
    @Test
    public void test3() {
        BiFunction<Integer, String, Employee> func = (id, name) -> new Employee(id, name);
        Employee tom = func.apply(1001, "Tom");
        System.out.println(tom);

        BiFunction<Integer, String, Employee> func2 = Employee::new;
        Employee jack = func2.apply(1002, "Jack");
        System.out.println(jack);
    }

    /**
     * 数组引用
     * Function R apply(T t)
     */
    @Test
    public void test4() {
        Function<Integer, String[]> func = length -> new String[length];
        String[] apply = func.apply(5);
        System.out.println(Arrays.toString(apply));

        Function<Integer, String[]> func2 = String[]::new;
        System.out.println(Arrays.toString(func2.apply(6)));
    }

}
