package com.imooc.mall.enums;

import lombok.Getter;

/**
 * @author SaoE
 * @date 2022/2/18 15:59
 */
@Getter
public enum PaymentTypeEnum {

    PAY_ONLINE(1),
    ;

    Integer code;

    PaymentTypeEnum(Integer code) {
        this.code = code;
    }
}
