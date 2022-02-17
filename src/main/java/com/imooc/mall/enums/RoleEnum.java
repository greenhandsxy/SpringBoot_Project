package com.imooc.mall.enums;

import lombok.Getter;

/**
 * 角色0-管理员，1-普通用户
 * @author SaoE
 * @date 2022/2/9 20:27
 */
@Getter
public enum RoleEnum {
    Admin(0),

    CUSTOMER(1),

    ;

    Integer code;
    RoleEnum(Integer code) {
        this.code = code;

    }
}
