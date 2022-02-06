package com.example.ygo.common.utils;


import com.example.ygo.common.exception.GlobalException;
import com.example.ygo.entity.ResponseData;

/**
 * @author 林屹峰
 * @version 1.0
 * @className ResponseMsgUtil
 * @description TODO
 * @since 2022/1/16 22:10
 */
public class ResponseMsgUtil {

    /*
     * @Title success
     * @Description TODO()
     * @Author 林屹峰
     * @Since 2022/1/16 22:14
     * @param data
     * @Return com.example.server.pojo.ResponseData
     */
    public static ResponseData success(String msg,Object data){
        ResponseData res = new ResponseData();
        res.setCode("200");
        res.setMsg(msg);
        res.setData(data);
        return res;
    }

    public static ResponseData success(Object data){
        ResponseData res = new ResponseData();
        res.setCode(GlobalException.SUCCESS.getCode());
        res.setMsg(GlobalException.SUCCESS.getMsg());
        res.setData(data);
        return res;
    }

    public static ResponseData error(String msg){
        ResponseData res = new ResponseData();
        res.setCode("500");
        res.setMsg(msg);
        res.setData(null);
        return res;
    }

    public static ResponseData error(GlobalException ge){
        ResponseData res = new ResponseData();
        res.setCode(ge.getCode());
        res.setMsg(ge.getMsg());
        res.setData(null);
        return res;
    }
}
