package com.example.srpingbootvalidation.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Validator;


/**
 * @Classname ValidatorUtils
 * @Description
 * @Date 2020/10/17 13:58
 * @Created gengxiao
 */

@Component
public class ValidatorUtils {

    public static Validator validator;

    @Autowired
    public void setValidator(Validator validator){
        ValidatorUtils.validator = validator;
    }
}
