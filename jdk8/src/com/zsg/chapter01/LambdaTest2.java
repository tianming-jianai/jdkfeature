package com.zsg.chapter01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.zsg.chapter01
 * @Author: 张世罡
 * @CreateTime: 2022/8/14 1:27
 * @Description:
 */
public class LambdaTest2 {
    /**
     * 测试 消费型
     */
    @Test
    public void test1() {
        happyTime(2D, new Consumer<Double>() {
            @Override
            public void accept(Double money) {
                System.out.println(String.format("花%.0f块钱买了瓶可乐", money));
            }
        });

        happyTime(30D, money -> System.out.println(String.format("花%.2f元，玩了把真人模拟射击", money)));
    }

    public void happyTime(Double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    /**
     * 测试 断定型
     */
    @Test
    public void test2() {
        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "普京");
        List<String> filterResult = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterResult);

        System.out.println(filterString(list, s -> s.contains("京")));
    }

    public List<String> filterString(List<String> list, Predicate<String> predicate) {
        ArrayList<String> newList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                newList.add(s);
            }
        }
        return newList;
    }
}
