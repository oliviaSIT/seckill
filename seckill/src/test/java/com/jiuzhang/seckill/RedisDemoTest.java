package com.jiuzhang.seckill;

import com.jiuzhang.seckill.util.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RedisDemoTest {
    @Resource
    private RedisService redisService;


    @Test
    public void  stockTest(){
        redisService.setValue("stock:19",10L);
    }


    @Test
    public void getStockTest(){
        String stock =  redisService.getValue("stock:19");
        assertEquals(new Long(stock), 10L);
    }

    @Test
    public void stockDeductValidatorTest(){
        boolean result =  redisService.stockDeductValidator("stock:19");
        assertTrue(result);
        String stock =  redisService.getValue("stock:19");
        System.out.println("stock:"+stock);
        assertEquals(new Long(stock), 9L);
    }
}
