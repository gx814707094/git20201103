package com.example.srpingbootvalidation.bean;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * @Classname Car
 * @Description
 * @Date 2020/10/17 16:11
 * @Created gengxiao
 */
@Data
public class Car {

    @Null
    private Integer id;

    @NotNull
    @NotEmpty
    private String color;

    @Min(value = 0)
    @Max(value = 10000)
    private Double price;
}
