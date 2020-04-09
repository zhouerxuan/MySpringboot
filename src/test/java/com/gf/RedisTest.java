package com.gf;

import com.gf.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisUtil redisUtil;
    @Test
    public void redisTest() {
        Boolean result = redisUtil.set("myLove","TT");
        System.out.println(result);
        if(result){
            String value = (String)redisUtil.get("myLove");
            System.out.println(value);
        }

    }
}
