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
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private Integer age;
    private Integer salary;
}
