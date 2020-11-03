package com.example.srpingbootvalidation;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @Classname TestMain
 * @Description
 * @Date 2020/10/19 8:35
 * @Created gengxiao
 */
public class TestMain {
    public static void main(String[] args) {
        A a = new A();
        a.setId(new BigDecimal(1000));
        final BigDecimal b = new BigDecimal(10);
        Optional.ofNullable(a).ifPresent(a2 -> {
            System.out.println(a2.getId());
        });
    }
}


@Data
class A{
    private BigDecimal id;


}