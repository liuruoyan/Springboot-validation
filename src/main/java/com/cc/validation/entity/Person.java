package com.cc.validation.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;

@Data
public class Person {

    @NotEmpty(message = "uname: must not be empty!")
    private String uname;

    @NotEmpty(message = "upwd: must not be empty!")
    private String upwd;

    @Range(min = 1, max = 2, message = "age:数据范围只能取1或2")
    private Integer age;


}
