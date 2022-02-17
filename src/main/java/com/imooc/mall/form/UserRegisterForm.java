package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author SaoE
 * @date 2022/2/9 21:32
 */
@Data
public class UserRegisterForm {

//    @NotBlank   用于String，判断空格(不能为空格)
//    @NotNull    用于判断是否为Null
//    @NotEmpty   用于集合（数组、集合等是否为空）

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;
}
