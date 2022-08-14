package com.zsg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.zsg.pojo
 * @Author: 张世罡
 * @CreateTime: 2022/8/14 2:36
 * @Description:
 */
@Data
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee() {
        System.out.println("Employee NoArgsConstructor ...");
    }

    public Employee(Integer id) {
        this.id = id;
        System.out.println("Employee(int id) ...");
    }

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("Employee(int id, String name) ...");
    }
}
