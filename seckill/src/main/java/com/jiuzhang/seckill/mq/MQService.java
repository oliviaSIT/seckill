package com.jiuzhang.seckill.mq;


import org.apache.activemq.ScheduledMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.TextMessage;

@Service
public class MQService {

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     *  发送消息
     * @param topic
     * @param body
     * @throws Exception
     */
    public void sendMessage(String topic,String body) throws Exception {
        jmsTemplate.send(topic, session -> session.createTextMessage(body));
    }

    /**
     * 发送延时消息
     *
     * @param topic
     * @param body
     * @param delayTime
     * @throws Exception
     */
    public void sendDelayMessage(String topic, String body, int delayTime) throws Exception {
        jmsTemplate.send(topic, session -> {
            TextMessage textMessage = session.createTextMessage(body);
            textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delayTime);
            return textMessage;
        });

    }
}
