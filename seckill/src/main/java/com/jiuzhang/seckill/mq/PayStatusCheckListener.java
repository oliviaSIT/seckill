package com.jiuzhang.seckill.mq;


import com.alibaba.fastjson.JSON;
import com.jiuzhang.seckill.db.dao.OrderDao;
import com.jiuzhang.seckill.db.po.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class PayStatusCheckListener {
    @Autowired
    private OrderDao  orderDao;
    @JmsListener(destination = "pay_check")
    public void receiveMessage(String message) {
        log.info("接收到订单支付状态校验消息:" + message);
        Order order = JSON.parseObject(message, Order.class);
        //1.查询订单
        Order orderInfo = orderDao.queryOrder(order.getOrderNo());
        //2.判读订单是否完成支付
        if (orderInfo.getOrderStatus() != 2) {
            //3.未完成支付关闭订单
            log.info("未完成支付关闭订单,订单号："+orderInfo.getOrderNo());
            orderInfo.setOrderStatus(99);
            orderDao.updateOrder(orderInfo);
        }
    }
}
