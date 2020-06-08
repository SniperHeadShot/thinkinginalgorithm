package com.bat.data.structure.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 *
 * @author ZhengYu
 * @version 1.0 2020/6/3 15:18
 **/
@Data
@NoArgsConstructor
public class User {

    private String name;

    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
