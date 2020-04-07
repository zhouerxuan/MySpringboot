package com.gf.utils;

import com.gf.common.ResultEnum;

public class JsonResultUtil {
    public static JsonResult success(Object object){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(0);
        jsonResult.setMsg("成功");
        jsonResult.setData(object);
        return jsonResult;
    }

    public static JsonResult success(){
        return success(null);
    }

    /*配合自定义异常类，枚举类使用code*/
    public static JsonResult error(Integer code, String msg){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(code);
        jsonResult.setMsg(msg);
        return jsonResult;
    }

    /*配合自定义异常类，枚举类使用code*/
    public static JsonResult error(ResultEnum resultEnum){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(resultEnum.getCode());
        jsonResult.setMsg(resultEnum.getMsg());
        return jsonResult;
    }

}
