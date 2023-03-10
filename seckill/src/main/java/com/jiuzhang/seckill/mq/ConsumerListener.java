package com.jiuzhang.seckill.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener  {
    @JmsListener(destination = "test")
    public void receiveMessage(String message) {
        try {
            System.out.println("receive message:" + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
