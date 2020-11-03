package com.example.srpingbootvalidation.annoation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Classname ValidList
 * @Description
 * @Date 2020/10/17 16:19
 * @Created gengxiao
 */
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {ValidListHandler.class})
public @interface ValidList {

//    Class<?>[] groupings() default {Default.class};

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default{};
}
