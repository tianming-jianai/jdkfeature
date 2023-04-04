package com.itheima.topic1.optional;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.itheima.topic1.optional
 * @author: 张世罡
 * @CreateTime: 2023/4/4 23:12
 * @Description:
 */
public class User {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
