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
        redisService.setValue("stock:3",500L);
    }


    @Test
    public void getStockTest(){
        String stock =  redisService.getValue("stock:3");
        assertEquals(new Long(stock), 500L);
    }

    @Test
    public void stockDeductValidatorTest(){
        boolean result =  redisService.stockDeductValidator("stock:2");
        assertTrue(result);
        String stock =  redisService.getValue("stock:2");
        System.out.println("stock:"+stock);
        assertEquals(new Long(stock), 100L);
    }

    @Test
    public void revertStock() {
        String stock = redisService.getValue("stock:19");
        System.out.println("回滚库存之前的库存：" + stock);

        redisService.revertStock("stock:19");

        stock = redisService.getValue("stock:19");
        System.out.println("回滚库存之后的库存：" + stock);
    }

    @Test
    public void removeLimitMember() {
        redisService.removeLimitMember(2, 1234);
    }
}
