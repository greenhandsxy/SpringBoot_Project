package com.imooc.mall.enums;

import lombok.Getter;

/**
 * 订单状态：0-已取消，10-未支付，20-已支付，40-已发货，50-交易成功，60-交易关闭
 * @author SaoE
 * @date 2022/2/18 16:53
 */
@Getter
public enum OrderStatusEnum {

    CANCEL(0,"已取消"),

    NO_PAY(10,"未支付"),

    PAID(20,"已支付"),

    SHIPPED(40,"已发货"),

    TRADE_SUCCESS(50,"交易成功"),

    TRADE_CLOSE(60,"交易关闭"),

    ;

    Integer code;

    String desc;

    OrderStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
