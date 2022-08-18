package com.zsg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.zsg.pojo
 * @Author: 张世罡
 * @CreateTime: 2022/8/18 21:38
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Boy {
    private Girl girl;
}
