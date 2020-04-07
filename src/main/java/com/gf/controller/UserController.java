package com.gf.controller;

import com.demo.starter.service.MsgService;
import com.gf.entity.User;
import com.gf.mapper.UserMapper;
import com.gf.utils.JsonResult;
import com.gf.utils.JsonResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserMapper userMapper;
    @Resource
    private MsgService msgService;

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getAllUsers(){
        //这里测试的自定义starter 短信发送相关功能
        msgService.sendMsg("测试消息");
        List<User> list = userMapper.getAllUsers();
        return  JsonResultUtil.success(list);
    }

}
