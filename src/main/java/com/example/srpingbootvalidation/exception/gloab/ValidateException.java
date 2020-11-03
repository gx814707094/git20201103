package com.example.srpingbootvalidation.exception.gloab;

import com.example.srpingbootvalidation.utils.ValidatorUtils;
import lombok.Getter;
import lombok.Setter;

import javax.validation.ConstraintViolation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Classname ValidateException
 * @Description
 * @Date 2020/10/17 16:25
 * @Created gengxiao
 */

@Setter
@Getter
public class ValidateException extends RuntimeException{
    private Map<Integer,Set<ConstraintViolation<Object>>> errors;

    public ValidateException(Map<Integer,Set<ConstraintViolation<Object>>> errors){
        this.errors = errors;
        System.out.println("error:" + errors.get(0));
    }

}
