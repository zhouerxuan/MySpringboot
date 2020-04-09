package com.gf.controller;

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

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getAllUsers(){
        List<User> list = userMapper.getAllUsers();
        return  JsonResultUtil.success(list);
    }

}
