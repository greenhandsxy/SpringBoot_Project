package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author SaoE
 * @date 2022/2/10 15:58
 */
@Data
public class UserLoginForm {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
