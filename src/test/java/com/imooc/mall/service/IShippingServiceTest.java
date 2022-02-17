package com.imooc.mall.service;

import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.ShippingForm;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author SaoE
 * @date 2022/2/16 17:59
 */
@Slf4j
public class IShippingServiceTest extends MallApplicationTests {

    @Autowired
    private IShippingService shippingService;

    private Integer uid = 1;

    private ShippingForm shippingForm;

    private Integer shippingId = 10;

    @Before
    public void before(){
        shippingForm = new ShippingForm();
        shippingForm.setReceiverName("肖逸");
        shippingForm.setReceiverAddress("新姜窑花园");
        shippingForm.setReceiverCity("苏州");
        shippingForm.setReceiverMobile("0512-66264276");
        shippingForm.setReceiverPhone("18120063446");
        shippingForm.setReceiverProvince("江苏");
        shippingForm.setReceiverDistrict("吴中区");
        shippingForm.setReceiverZip("215000");

        add();
    }


    public void add() {
        ResponseVo<Map<String, Integer>> responseVo = shippingService.add(uid, shippingForm);
        log.info("result={}",responseVo);
        this.shippingId = responseVo.getData().get("shippingId");
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @After
    public void delete() {
        ResponseVo responseVo = shippingService.delete(uid, shippingId);
        log.info("result={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void update() {
        shippingForm.setReceiverCity("南京");
        ResponseVo responseVo = shippingService.update(uid,shippingId, shippingForm);
        log.info("result={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());

    }

    @Test
    public void lsit() {
        ResponseVo responseVo = shippingService.list(uid,1,10);
        log.info("result={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());

    }
}