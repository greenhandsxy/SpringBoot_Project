package com.imooc.mall.vo;

import lombok.Data;

import java.util.List;

/**
 * @author SaoE
 * @date 2022/2/11 15:51
 */
@Data
public class CategoryVo {

    private Integer id;

    private Integer parentId;

    private String name;

    private Integer status;

    private Integer sortOrder;

    private List<CategoryVo> subCategories;
}
