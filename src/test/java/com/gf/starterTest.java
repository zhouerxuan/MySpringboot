package com.gf;

import com.demo.starter.service.MsgService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class starterTest {
    @Resource
    private MsgService msgService;
    @Test
    public void starterTest() {
        //这里测试的自定义starter 短信发送相关功能
        msgService.sendMsg("测试消息");
    }
}
