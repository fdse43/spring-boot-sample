package com.cn.boot.sample.zookeeper.register.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Chen Nan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaTagInfo {
    private String name;
    private int weight;
}
