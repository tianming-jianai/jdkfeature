package com.zsg.chapter03;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.zsg.chapter03
 * @Author: 张世罡
 * @CreateTime: 2022/8/21 23:05
 * @Description:
 * 3. 总结
 * 3.1 lambda表达式总结
 * 左边： lambda形参列表的参数可以省略（类型推断）；如果lambda形参列表只有一个参数，其一对()也可以省略
 * 右边： lambda体应该使用一对{}包裹；如果lambda体只有一条执行语句（可能是return 语句），省略这一对{}和return关键字
 *
 * 3.2 何时使用lambda表达式？
 * 当需要一个函数式接口实例化的时候，可以使用lambda表达式
 *
 * 3.3 何时使用给定的函数式接口？
 * 如果我们开发中需要定义一个函数式接口，首先看看在已有的jdk提供的函数式接口是否提供了能满足需求的函数式接口。
 * 如果有，则直接调用即可，不需要自己再定义了。
 *
 * 3.4 方法引用
 * 使用情境：当要传递lambda体的操作，已经有实现的方法了，可以使用方法引用
 * 对象::非静态方法
 * 类::非静态方法
 * 类::静态方法
 *
 * 3.5 构造器引用
 * 类名::new
 *
 * 3.6 数组引用
 * String[]::new
 *
 *
 */
public class summary {
}

/**
 * 4. Stream API
 * 过滤、排序、映射、规约
 * 1）Stream 自己不会存储对象
 * 2）Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * 3）Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
 * 实例化：集合list.stream()、数组Arrays.stream()、Stream.of()、创建无限流Stream.iterate(),Stream.generate()
 * 中间操作：筛选和切片；映射；排序；（处理数据源）
 * 终结操作：匹配与查找；规约；收集Collectors；（一但执行终止操作，就执行中间操作，并产生结果。之后，不会再被使用）
 *
 * 5. Optional类
 * 能保证不会出现空指针异常
 * 创建：
 *      Optional.of(T t)
 *      Optional.empty()
 *      Optional.ofNullable(T t)
 * 判断：
 *      boolean isPresent() 判断是否包含对象
 *      void ifPresent(Consumer<? super T> consumer)如果有值就执行Consumer接口的实现代码，并且该值会作为参数传给它
 * 获取：
 *      T get()
 *      T orElse(T other) 如果有值将其返回，否则返回指定的other对象
 *      T orElseGet(Supplier<? extends X> exceptionSupplier) 如果有值则将其返回，否则返回由Supplier接口实现提供的对象
 *      T orElseThrow(Supplier<? extends X> exceptionSupplier) 如果有值将其返回，否则抛出由Supplier接口实现提供的异常
 */