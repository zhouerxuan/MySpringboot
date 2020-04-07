package com.gf.handler;

import com.gf.common.ResultEnum;
import com.gf.utils.HttpResposeWriter;
import com.gf.utils.JsonResult;
import com.gf.utils.JsonResultUtil;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Galen
 * @Date: 2019/3/28-9:17
 * @Description: 认证失败的处理
 **/
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        JsonResult respBean;
        if (exception instanceof BadCredentialsException ||
                exception instanceof UsernameNotFoundException) {
            respBean = JsonResultUtil.error(ResultEnum.ACCCOUNTPWD_ERROR);
        } else if (exception instanceof LockedException) {
            respBean = JsonResultUtil.error(ResultEnum.ACCOUNTTLOC_ERROR);
        } else if (exception instanceof CredentialsExpiredException) {
            respBean = JsonResultUtil.error(ResultEnum.PWDEXPIRE_ERROR);
        } else if (exception instanceof AccountExpiredException) {
            respBean = JsonResultUtil.error(ResultEnum.ACCOUNTEXPIRE_ERROR);
        } else if (exception instanceof DisabledException) {
            respBean = JsonResultUtil.error(ResultEnum.ACCOUNTFORBID_ERROR);
        } else {
            respBean = JsonResultUtil.error(ResultEnum.LOGIN_ERROR);
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        HttpResposeWriter.writeToHRep(response,respBean);
    }
}
