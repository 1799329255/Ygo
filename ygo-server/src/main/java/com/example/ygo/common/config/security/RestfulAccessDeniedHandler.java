package com.example.ygo.common.config.security;

import com.alibaba.fastjson.JSONObject;
import com.example.ygo.common.exception.GlobalException;
import com.example.ygo.common.utils.ResponseMsgUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 当访问接口没有权限时，自定义的返回结果
 *
 * @author 旋木頵頵
 * @date 2021/10/20 21:48
 * @email 1020626977@qq.com
 */
@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/javascript;charset=utf-8");
        response.getWriter().print(JSONObject.toJSONString(ResponseMsgUtil.error(GlobalException.PERMISSION_DENIED)));
    }
}
