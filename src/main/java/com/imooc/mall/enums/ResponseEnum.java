package com.imooc.mall.enums;

import lombok.Getter;

/**
 * @author SaoE
 * @date 2022/2/9 21:18
 */
@Getter
public enum ResponseEnum {

    ERROR(-1,"服务端错误"),

    SUCCESS(0,"成功"),

    PASSWORD_ERROR(1,"密码错误"),

    USERNAME_EXIST(2,"用户名已存在"),

    PARAM_ERROR(3,"参数错误"),

    EMAIL_EXIST(4,"邮箱已存在"),

    NEED_LOGIN(10,"用户未登录，请先登录"),

    USERNAME_OR_PASSWORD_ERROR(11,"用户名或密码错误"),

    PRODUCT_OFF_SALE_OR_DELETE(12,"商品下架或删除"),

    PRODUCT_NOT_EXIST(13,"商品不存在"),

    PRODUCT_STOCK_ERROR(14,"库存不正确"),

    CART_PRODUCT_NOT_EXIST(15,"购物车里无此商品"),

    DELETE_SHIPPING_FAIL(16,"删除收货地址失败"),

    SHIPPING_NOT_EXIST(17,"收货地址不存在"),

    CART_SELECTED_IS_EMPTY(18,"请选择商品后下单"),

    ;

    Integer code;

    String desc;

    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
