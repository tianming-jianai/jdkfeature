package com.zsg.chapter02;

import com.zsg.pojo.Employee;
import com.zsg.pojo.EmployeeData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.zsg.chapter02
 * @Author: 张世罡
 * @CreateTime: 2022/8/15 21:43
 * @Description: Stream 的终止操作
 */
public class StreamAPITest3 {

    List<Employee> list = null;

    @BeforeEach
    public void beforeEach() {
        list = EmployeeData.getEmployees();
    }

    /**
     * 1. 匹配与查找
     */
    @Test
    public void test1() {
        // allMatch(Predicate p) 检查是否匹配素有元素
        // 练习：是否所有员工的年龄都大于18
        boolean allMatch = list.stream().allMatch(e -> e.getAge() > 18);
        System.out.println("all > 18 : " + allMatch);

        // anyMatch(Predicate p) 检查是否至少匹配一个元素。
        // 练习：是否存在员工的工资大于10000
        boolean anyMatch = list.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println("any salary > 10000 : " + anyMatch);

        // noneMatch(Predicate p) 检查是否没有匹配的元素。
        // 练习：是否存在员工姓“雷”
        boolean noneMatch = list.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println("exists 雷 : " + noneMatch);

        // findFirst() 返回第一个元素
        Optional<Employee> first = list.stream().findFirst();
        System.out.println(first);

        // findAny() 返回流中任意元素
        Optional<Employee> any = list.stream().findAny();
        System.out.println(any);

        // count() 返回流中元素的总个数
        long count = list.stream().count();
        System.out.println("count : " + count);

        // max(Comparator c) 返回流中最大值
        // 返回员工最大工资
        Optional<Double> maxSalary = list.stream().map(e -> e.getSalary()).max(Double::compare);
        System.out.println(maxSalary);

        // min(Comparator c) 返回流中最小值
        // 返回最低工资员工
        Optional<Employee> max = list.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max);

        // foreach(Consumer c) 内部迭代
        // 使用Collection接口需要用户去做迭代，成为外部迭代。相反，Stream API使用内部迭代——它帮你做了
    }

    /**
     * 2. 规约
     */
    @Test
    public void test2() {
        // reduce(T identity, BinaryOperator) 可以将流中元素反复结合起来，得到一个值。返回
        // 练习1：计算1-10的自然数的和
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = integers.stream().reduce(0, Integer::sum);
        System.out.println("sum: " + sum);

        // reduce(BinaryOperator) 可以将流中元素反复结合起来，得到一个值。返回Optional<T>
        // 练习2：计算所有员工工资的总和
        Double sumSalary = list.stream().map(Employee::getSalary).reduce(0D, Double::sum);
        System.out.println("sum salary : " + sumSalary);
    }

    /**
     * 3. 收集
     */
    @Test
    public void test3(){
        // collect(Collector c) 将流转转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
        // 练习：查找工资大于6000的员工，结果返回一个List或Set
        List<Employee> employeeList = list.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        Set<Employee> employeeSet = list.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
    }
}
