package com.gf.handler;

import com.gf.utils.HttpResposeWriter;
import com.gf.utils.JsonResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ExceptionHandler {
    public static final String ERROR_VIEW="error";

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response,Exception e) throws IOException {
        e.printStackTrace();
        if(isAjax(request)){
                response.setStatus(200);
                HttpResposeWriter.writeToHRep(response,JsonResultUtil.error(-1,e.getMessage()));
                return null;
        }else{
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception",e);
            mav.addObject("url",request.getRequestURL());
            mav.setViewName(ERROR_VIEW);
            return mav;
        }
    }

    public static boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With")!=null&&
                "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }
}
