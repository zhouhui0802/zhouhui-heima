package com.heima.freemarker.entity;


import lombok.Data;

import java.util.Date;

/**
 * @author zhouhui
 * @version 1.0
 * @description TODO
 * @date 2026/2/26 11:22
 */

@Data
public class Student {

    private String name; //姓名

    private int age; //年龄

    private Date birthday; //生日

    private Float money; //钱包
}
