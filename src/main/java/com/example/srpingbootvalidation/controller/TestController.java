package com.example.srpingbootvalidation.controller;

import com.example.srpingbootvalidation.annoation.ValidList;
import com.example.srpingbootvalidation.bean.Person;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Classname TestController
 * @Description
 * @Date 2020/10/17 16:00
 * @Created gengxiao
 */
@RestController
@Validated
public class TestController {

    @PostMapping("/add/person")
    public String addPerson(@RequestBody @Valid Person person){
        return "okasdasdsadasdsadasdasd";
    }

    @PostMapping("/batch/add/person")
    public String batchAddPerson(@RequestBody @ValidList List<Person> personList){
        System.out.println(personList.size());
        return "gx2";
    }




}
