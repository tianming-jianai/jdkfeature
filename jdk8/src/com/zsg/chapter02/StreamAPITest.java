package com.zsg.chapter02;

import com.zsg.pojo.Employee;
import com.zsg.pojo.EmployeeData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.zsg.chapter02
 * @Author: 张世罡
 * @CreateTime: 2022/8/14 20:13
 * @Description:
 */
public class StreamAPITest {

    List<Employee> employees = null;

    @BeforeEach
    public void beforeEach() {
        employees = EmployeeData.getEmployees();
    }

    /**
     * 创建Stream方式一：通过集合
     */
    @Test
    public void test1() {
        Stream<Employee> stream = employees.stream();
        Stream<Employee> stream1 = employees.parallelStream();
    }

    /**
     * 创建Stream方式二：通过数组
     */
    @Test
    public void test2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(arr);

        Employee[] arr1 = new Employee[]{employees.get(0), employees.get(1)};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    /**
     * 创建Stream方式三：通过Stream of()
     */
    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    /**
     * 创建Stream方式四：创建无限流
     */
    @Test
    public void test4() {
        // 遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
        System.out.println("---------------------");
        // 输出10个随机数
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
