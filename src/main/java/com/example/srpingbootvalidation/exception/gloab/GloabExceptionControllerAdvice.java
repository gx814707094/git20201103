package com.example.srpingbootvalidation.exception.gloab;

import com.alibaba.fastjson.JSON;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Classname GloabExceptionControllerAdvice
 * @Description
 * @Date 2020/10/17 16:01
 * @Created gengxiao
 */

@ResponseBody
@ControllerAdvice
public class GloabExceptionControllerAdvice {

    @ExceptionHandler
    public String validateListHandler(ValidateException ve){
        Map<Integer, Set<ConstraintViolation<Object>>> errors = ve.getErrors();
        return JSON.toJSONString(errors,true);
    }

    @ExceptionHandler
    public String validateHandler(MethodArgumentNotValidException validEx){
        BindingResult bindingResult = validEx.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        Map<String,String> errMap = new HashMap<>();
        fieldErrors.stream().forEach(f -> {
            String fieldName = f.getField();
            String errMsg = f.getDefaultMessage();
            errMap.put(fieldName,errMsg);
        });
        return JSON.toJSONString(errMap,true);
    }
}
