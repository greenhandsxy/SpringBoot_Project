package com.imooc.mall.form;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 添加商品
 * @author SaoE
 * @date 2022/2/12 22:51
 */
@Data
public class CartAddForm {

    @NotNull
    private Integer productId;

    /**
     * 默认选中
     */
    private Boolean selected = true;
}
