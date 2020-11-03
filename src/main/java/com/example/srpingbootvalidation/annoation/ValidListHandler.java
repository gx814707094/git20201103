package com.example.srpingbootvalidation.annoation;

import com.alibaba.fastjson.JSON;
import com.example.srpingbootvalidation.exception.gloab.ValidateException;
import com.example.srpingbootvalidation.utils.ValidatorUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Classname ValidListHandler
 * @Description
 * @Date 2020/10/17 16:20
 * @Created gengxiao
 */

public class ValidListHandler implements ConstraintValidator<ValidList, List> {

    Class<?>[] groups;
    @Override
    public void initialize(ValidList constraintAnnotation) {
         groups = constraintAnnotation.groups();
    }

    @Override
    public boolean isValid(List list, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(JSON.toJSONString(list,true));
        Map<Integer,Set<ConstraintViolation<Object>>> errors = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            Object o = list.get(i);
            System.out.println(o);
            Set<ConstraintViolation<Object>> errSet = ValidatorUtils.validator.validate(o, groups);
            errors.put(i,errSet);
        }
        if(errors.size() > 0){
            System.out.println("错误:" + errors.size());
            throw new ValidateException(errors);
        }
        return true;
    }
}
