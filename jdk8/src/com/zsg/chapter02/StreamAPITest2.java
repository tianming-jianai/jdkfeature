package com.zsg.chapter02;

import com.zsg.pojo.Employee;
import com.zsg.pojo.EmployeeData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.zsg.chapter02
 * @Author: 张世罡
 * @CreateTime: 2022/8/15 19:56
 * @Description: 测试Stream的中间操作
 */
public class StreamAPITest2 {

    List<Employee> list = null;

    @BeforeEach
    public void beforeEach() {
        list = EmployeeData.getEmployees();
    }

    /**
     * 1. 筛选与切片
     */
    @Test
    public void test1() {
        // filter(Predicate p) 接收Lambda，从流中排除某些元素
        list.stream().filter(e -> e.getSalary() > 7000).forEach(System.out::println);
        System.out.println("-------------------");

        // limit(n) 截断流，使其元素不超过给定数量
        list.stream().limit(3).forEach(System.out::println);
        System.out.println("-------------------");

        // skip(n) 跳过元素，返回一个丢掉了前n个元素的流，若流中元素不足n个，则返回一个空流。与limit(n)互补
        list.stream().skip(3).forEach(System.out::println);
        System.out.println("-------------------");

        // distinct() 筛选，通过流所生成元素的hashCode()和equals()去除重复元素
        list.add(new Employee(1010, "zsg", 18, 20000));
        list.add(new Employee(1010, "zsg", 18, 20000));
        list.add(new Employee(1010, "zsg", 18, 20000));
        list.stream().distinct().forEach(System.out::println);
    }

    /**
     * 2. 映射
     */
    @Test
    public void test2() {
        // map(Function f) 接收一个函数作为参数将元素换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> strings = Arrays.asList("aa", "bb", "cc", "dd", "ee");
        strings.stream().map(e -> e.toUpperCase()).forEach(System.out::println);
        list.stream().map(Employee::getName).filter(name -> name.length() > 3).forEach(System.out::println);
        System.out.println("------------------");
        Stream<Stream<Character>> streamStream = strings.stream().map(StreamAPITest2::formatString);
        streamStream.forEach(s -> s.forEach(System.out::println));

        System.out.println("------------------");
        // flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        Stream<Character> characterStream = strings.stream().flatMap(StreamAPITest2::formatString);
        characterStream.forEach(System.out::println);
    }

    private static Stream<Character> formatString(String s) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : s.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    /**
     * 3. 排序
     */
    @Test
    public void test3() {
        // sorted() 自然排序
        List<Integer> integers = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);
        integers.stream().sorted().forEach(System.out::println);
        System.out.println("-------------------");

        // sorted(Comparator comp) 定制排序
        list.stream().sorted((e1, e2) -> {
            int res = Integer.compare(e1.getAge(), e2.getAge());
            if (res != 0) {
                return res;
            } else {
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
        }).forEach(System.out::println);
    }

}
