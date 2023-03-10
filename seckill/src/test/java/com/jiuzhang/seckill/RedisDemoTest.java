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
        redisService.setValue("stock:2",100L);
    }


    @Test
    public void getStockTest(){
        String stock =  redisService.getValue("stock:2");
        assertEquals(new Long(stock), 100L);
    }

    @Test
    public void stockDeductValidatorTest(){
        boolean result =  redisService.stockDeductValidator("stock:2");
        assertTrue(result);
        String stock =  redisService.getValue("stock:2");
        System.out.println("stock:"+stock);
        assertEquals(new Long(stock), 100L);
    }
}
