package com.gf.handler;

import com.gf.common.ResultEnum;
import com.gf.utils.HttpResposeWriter;
import com.gf.utils.JsonResult;
import com.gf.utils.JsonResultUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Galen
 * @Date: 2019/3/27-17:36
 * @Description: Denied是拒签的意思
 * 此处我们可以自定义403响应的内容,让他返回我们的错误逻辑提示
 **/
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {
        Boolean isAjax = ExceptionHandler.isAjax(request);
        if(!isAjax){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            request.setAttribute(WebAttributes.ACCESS_DENIED_403, accessDeniedException);
            response.sendRedirect("/403");
            //request.getRequestDispatcher(errorPage).forward(request, response);
        }else {
            response.setStatus(HttpServletResponse.SC_OK);
            JsonResult error = JsonResultUtil.error(ResultEnum.PERMITIONDENIED_ERROR);
            HttpResposeWriter.writeToHRep(response,error);
        }
    }
}
