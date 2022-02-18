package com.imooc.mall.service;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.vo.OrderVo;
import com.imooc.mall.vo.ResponseVo;
import sun.plugin2.os.windows.OVERLAPPED;

/**
 * @author SaoE
 * @date 2022/2/17 20:27
 */
public interface IOrderService {

    /***
     * 创建订单
     * @param uid
     * @param shippingId
     * @return
     */
    ResponseVo<OrderVo> create(Integer uid, Integer shippingId);
}
