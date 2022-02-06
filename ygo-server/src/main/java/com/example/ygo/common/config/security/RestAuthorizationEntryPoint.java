package com.example.ygo.common.config.security;

import com.alibaba.fastjson.JSONObject;
import com.example.ygo.common.exception.GlobalException;
import com.example.ygo.common.utils.ResponseMsgUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 当未登录或token失效时访问接口时自定义的返回结果
 *
 * @author 旋木頵頵
 * @date 2021/10/20 21:44
 * @email 1020626977@qq.com
 */
@Component
public class RestAuthorizationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/javascript;charset=utf-8");
        response.getWriter().print(JSONObject.toJSONString(ResponseMsgUtil.error(GlobalException.NOT_LOGIN_ERROR)));
    }
}
