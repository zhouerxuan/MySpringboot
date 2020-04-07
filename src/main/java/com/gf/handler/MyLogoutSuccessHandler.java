package com.gf.handler;

import com.gf.common.ResultEnum;
import com.gf.utils.HttpResposeWriter;
import com.gf.utils.JsonResult;
import com.gf.utils.JsonResultUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Galen
 * @Date: 2019/3/28-9:21
 * @Description: 注销登录处理
 **/
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        JsonResult result = JsonResultUtil.error(ResultEnum.LOGOUT_SUCCESS);
        HttpResposeWriter.writeToHRep(response,result);
    }
}
