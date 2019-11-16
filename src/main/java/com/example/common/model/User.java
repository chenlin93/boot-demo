package com.example.common.model;

import lombok.Data;

/**
 * 实体类
 * */
@Data
public class User {

    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private String adress;
}