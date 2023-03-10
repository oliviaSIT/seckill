package com.jiuzhang.seckill;

import com.jiuzhang.seckill.mq.MQService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MQTest {
    @Autowired
    MQService mqService;

    @Test
    public void sendMessageTest() throws Exception {
        mqService.sendMessage("test", "hello, River");
    }
}
