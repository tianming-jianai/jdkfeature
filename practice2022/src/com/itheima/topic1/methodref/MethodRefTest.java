package com.itheima.topic1.methodref;

import com.itheima.topic1.lambda.Swimmable;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.methodref
 * @author: 张世罡
 * @CreateTime: 2023/4/3 20:04
 * @Description:
 */
public class MethodRefTest {
    /**
     * 对象名::引用成员方法
     */
    @Test
    public void test() {
        Date now = new Date();
        Supplier<Long> supp = () -> {
            return now.getTime();
        };
        System.out.println(supp.get());
        Supplier<Long> supp2 = now::getTime;
        System.out.println(supp2.get());
    }

    /**
     * 类名::引用静态方法
     */
    @Test
    public void test2() {
        Supplier<Long> supp = () -> {
            return System.currentTimeMillis();
        };
        System.out.println(supp.get());

        Supplier<Long> supp2 = System::currentTimeMillis;
        System.out.println(supp2.get());
    }

    /**
     * 类名::引用实例方法
     */
    @Test
    public void test3() {
        Function<String, Integer> f1 = s -> {
            return s.length();
        };
        System.out.println(f1.apply("abc"));

        Function<String, Integer> f2 = String::length;
        System.out.println(f2.apply("hello"));

        BiFunction<String, Integer, String> bif = String::substring;
        String hello = bif.apply("hello", 2);
        System.out.println("hello = " + hello);
    }

    /**
     * 类名::引用构造器
     */
    @Test
    public void test4() {
        Supplier<Person> supp = () -> {
            return new Person();
        };
        System.out.println(supp.get());

        Supplier<Person> supp2 = Person::new;
        System.out.println(supp2.get());

        BiFunction<String, Integer, Person> fun2 = Person::new;
        System.out.println(fun2.apply("tom", 18));
    }

    /**
     * 数组::new 引用数组构造器
     */
    @Test
    public void test5() {
        Function<Integer, String[]> fun = len -> {
            return new String[len];
        };
        String[] arr1 = fun.apply(10);
        System.out.println(arr1 + "， " + arr1.length);

        Function<Integer, String[]> fun2 = String[]::new;
        String[] arr2 = fun2.apply(5);
        System.out.println(arr2 + "， " + arr2.length);
    }
}

class Person {

    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
