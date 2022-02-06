package com.example.ygo.common.exception;

/**
 * @author 林屹峰
 * @version 1.0
 * @className GlobalException
 * @description TODO
 * @since 2022/1/16 21:50
 * 代码code规则：
 * 0000-0999  系统异常
 * 1000-1999  业务异常
 * 9999	      未知异常
 */
public enum GlobalException {
    //////////////////页面异常////////////////
    SUCCESS("200", "成功!"),
    BODY_NOT_MATCH("400","请求的数据格式不符!"),
    NOT_LOGIN_ERROR("401","账号未登录或已过期"),
    PERMISSION_DENIED("403", "权限不足，请联系管理员!"),
    NOT_FOUND("404", "未找到该资源!"),

    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503","服务器正忙，请稍后再试!"),

    //////////////////系统异常////////////////
    DB_CONNECT_ERROR("0000","数据库连接异常"),
    FTP_CONNECT_ERROR("0001","FTP服务器连接失败"),
    FTP_CONFIG_NOT_FOUND("0002","FTP服务地址路径配置缺失"),
    STREAM_NOT_CLOSE("0003","outputStream流没有关闭"),
    INTEGRITY_CONSTRAINT_VIOLATION("0004","该数据有外键关联，操作失败！"),
    DATABASE_ERROR("0005","数据库异常，操作失败！"),


    //////////////////业务异常/////////////
    COMMON_ERROR("1000",""),
    REQ_PARAMS_ERROR("1001","请求参数校验失败"),
    ADD_DATA_ERROR("1002","增加数据失败"),
    UPDATE_DATA_ERROR("1003","修改数据失败"),
    DELETE_DATA_ERROR("1004","删除数据失败"),
    USER_LOGIN_ERROR("1005","用户名或密码错误"),
    USER_NOT_ENABLED_ERROR("1006","账号被禁用，请联系管理员"),
    CODE_ERROR("1007","验证码错误，请重新输入"),

    UNKNOWN_ERROR("9999","未知异常"),
    ;//注意：上面为逗号，此次为分号

    private String code;
    private String msg;

    GlobalException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
