package com.example.ygo.common.utils;

import com.example.ygo.common.exception.GlobalException;
import com.example.ygo.entity.ResponseData;

/**
 * @author 林屹峰
 * @version 1.0
 * @className LogUtil
 * @description TODO
 * @since 2022/1/19 16:44
 */
public class LogUtil {

    public static String outLogHead(StackTraceElement stackTraceElement, GlobalException ge){
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return  "\n"+className+"Controller --> "+methodName+"() error!"+
                "\n"+"code="+ge.getCode()+" - msg="+ge.getMsg();
    }

    public static String outLogHead(StackTraceElement stackTraceElement, String msg){
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return  "\n"+className+"Controller --> "+methodName+"() error!"+
                " - msg="+msg;
    }

    public static String outLogHead(StackTraceElement stackTraceElement, ResponseData responseData){
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return  "\n"+className+"Controller --> "+methodName+"() error!"+
                "\n"+"code="+responseData.getCode()+" - msg="+responseData.getMsg();
    }
}
