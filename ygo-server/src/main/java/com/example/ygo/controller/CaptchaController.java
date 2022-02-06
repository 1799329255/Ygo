package com.example.ygo.controller;

import com.example.ygo.common.exception.GlobalException;
import com.example.ygo.common.utils.LogUtil;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author 林屹峰
 * @version 1.0
 * @className CaptchaController
 * @description TODO
 * @since 2022/1/19 22:12
 */
@Controller
@RequestMapping
@Api(value = "验证码")
@Slf4j
public class CaptchaController {

    @Resource
    private DefaultKaptcha defaultKaptcha;

    @RequestMapping(value = "/captcha", produces = "image/jpeg", method = RequestMethod.GET)
    @ApiOperation(value = "验证码")
    public void captcha(HttpServletRequest request, HttpServletResponse response) {
        // 定义response输出类型为image/jpeg类型
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        // 开始生成验证码
        String text = defaultKaptcha.createText(); // 获取验证码文本内容
        System.out.println("验证码文本内容：" + text);
        request.getSession().setAttribute("captcha", text); //保存验证码到Session
        BufferedImage image = defaultKaptcha.createImage(text); // 根据文本内容创建图形验证码
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            ImageIO.write(image, "jpg", outputStream); // 输出流输出图片，格式为jpg
            outputStream.flush();
        } catch (IOException e) {
            log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1], GlobalException.UNKNOWN_ERROR), e);
            e.printStackTrace();
        } finally {
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    log.error(LogUtil.outLogHead(Thread.currentThread().getStackTrace()[1], GlobalException.STREAM_NOT_CLOSE), e);
                    e.printStackTrace();
                }
            }
        }
        // 生成验证码结束
    }
}

