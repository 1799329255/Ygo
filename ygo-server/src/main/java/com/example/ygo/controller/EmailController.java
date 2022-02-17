package com.example.ygo.controller;

import com.example.ygo.common.utils.EmailUtil;
import com.example.ygo.common.utils.LogUtil;
import com.example.ygo.common.utils.ResponseMsgUtil;
import com.example.ygo.entity.ResponseData;
import com.example.ygo.entity.User;
import com.example.ygo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 林屹峰
 * @version 1.0
 * @className EmailController
 * @description TODO
 * @since 2022/2/5 17:16
 */
@Controller
@RequestMapping
@Api(value = "邮箱验证码")
@Slf4j
public class EmailController {

    @Resource
    private EmailUtil emailUtil;
    @Resource
    private UserService userService;

    @RequestMapping(value = "/email", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "邮箱验证码")
    public ResponseData sendEmail(String email, HttpServletRequest request) {

        String emailCode = emailUtil.sendMail(email);
        //保存验证码到Session
        request.getSession().setAttribute("emailCode", emailCode);
        //验证码5分钟有效
        request.getSession().setMaxInactiveInterval(60*5);
        return ResponseMsgUtil.success(null);
    }

    @RequestMapping(value = "/emailRegister", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "邮箱验证码(注册使用)")
    public ResponseData sendEmailRegister(String email, HttpServletRequest request) {
        User user = userService.findByEmail(email);
        if (user!=null){
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1],"该邮箱已注册，请重新输入"));
            return ResponseMsgUtil.error("该邮箱已注册，请重新输入");
        }
        String emailCode = emailUtil.sendMail(email);
        //保存验证码到Session
        request.getSession().setAttribute("emailCode", emailCode);
        //验证码5分钟有效
        request.getSession().setMaxInactiveInterval(60*5);
        return ResponseMsgUtil.success(null);
    }
}
