package com.jiuzhang.seckill.mq;

import com.alibaba.fastjson.JSON;
import com.jiuzhang.seckill.db.dao.SeckillActivityDao;
import com.jiuzhang.seckill.db.po.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 支付完成消息处理
 * 扣减库存
 */
@Slf4j
@Component
@Transactional
public class PayDoneListener {
    @Autowired
    private SeckillActivityDao seckillActivityDao;

    @JmsListener(destination = "pay_done")
    public void receiveMessage(String message) {
        //1.解析创建订单请求消息
        log.info("接收到创建订单请求：" + message);
        Order order = JSON.parseObject(message, Order.class);
        //2.扣减库存
        seckillActivityDao.deductStock(order.getSeckillActivityId());
    }

}
