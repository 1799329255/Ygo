package com.example.ygo.entity;

/**
 * @author 林屹峰
 * @version 1.0
 * @className ResponseData
 * @description TODO
 * @since 2022/1/16 21:19
 */
public class ResponseData {
    //状态码
    private String code;
    //错误描述
    private String msg;
    //数据
    private Object data;

    public ResponseData() {
        super();
    }

    public ResponseData(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }

    public ResponseData(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
