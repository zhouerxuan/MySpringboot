package com.gf.common;

public enum ResultEnum {
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    ACCCOUNTPWD_ERROR(100,"账户名或者密码输入错误!"),
    ACCOUNTTLOC_ERROR(101,"账户被锁定，请联系管理员!"),
    PWDEXPIRE_ERROR(102,"密码过期，请联系管理员!"),
    ACCOUNTEXPIRE_ERROR(103,"账户过期，请联系管理员!"),
    ACCOUNTFORBID_ERROR(104,"账户被禁用，请联系管理员!"),
    LOGIN_ERROR(105,"登录失败!"),
    PERMITIONDENIED_ERROR(403,"权限不足"),
    LOGIN_SUCCESS(110,"登录成功"),
    LOGOUT_SUCCESS(111,"注销成功");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
