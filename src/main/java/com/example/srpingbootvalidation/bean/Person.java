package com.example.srpingbootvalidation.bean;

import com.example.srpingbootvalidation.annoation.PersonGroupSequenceProvider;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.group.GroupSequenceProvider;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * @Classname Person
 * @Description
 * @Date 2020/10/17 15:43
 * @Created gengxiao
 */
@Data
@GroupSequenceProvider(value = PersonGroupSequenceProvider.class)
public class Person {

    public interface lev1 {
    }

    public interface lev2 {
    }

    public interface lev3 {
    }


    @Null(message = "id只能为空")
    private Integer id;

    @NotEmpty
    @NotNull
    @Length(max = 20, message = "名称长度不能超过20")
    private String name;

    @NotNull
    @Min(value = 5, message = "年龄最小为5岁")
    @Max(value = 100, message = "年龄最大为100岁")
    private Integer age;

    @NotNull(message = "级别必须填写")
    @NotEmpty(message = "级别不能为空")
    //native2ascii
    @Pattern(regexp = "\u513f\u7ae5", groups = lev1.class)
    @Pattern(regexp = "\u9752\u5e74", groups = lev2.class)
    @Pattern(regexp = "\u6210\u5e74", groups = lev3.class)
    private String level;

    //级联验证
    @Valid
    private Car car;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", level='" + level + '\'' +
                ", car=" + car +
                '}';
    }
}















