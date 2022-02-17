package com.imooc.mall.service.impl;

import com.imooc.mall.service.IOrderService;
import com.imooc.mall.vo.OrderVo;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author SaoE
 * @date 2022/2/17 20:28
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Override
    public ResponseVo<OrderVo> create(Integer uid, Integer shippingId) {
        //收货地址校验（总之要查出来的）

        //获取购物车，校验（是否有商品、库存）

        //计算总价，只计算被选中的商品

        //生成订单，入库：order和order_item表，事务

        //减库存

        //更新购物车（选中的商品）

        //构造orderVo对象

        return null;
    }
}
