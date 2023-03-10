package com.jiuzhang.seckill;

import com.jiuzhang.seckill.db.dao.OrderDao;
import com.jiuzhang.seckill.db.mappers.OrderMapper;
import com.jiuzhang.seckill.db.po.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class OrderTest {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDao orderDao;

    @Test
    public void testCreateOrder() {
        Order order = new Order();
        order.setOrderNo("1");
        order.setOrderStatus(0);
        order.setSeckillActivityId(1L);
        order.setOrderAmount(1L);
        order.setUserId(1L);
        order.setCreateTime(new Date());
        orderMapper.insertSelective(order);
    }


}
