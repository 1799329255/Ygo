package com.example.ygo.common.utils;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * @author 林屹峰
 * @version 1.0
 * @className EmailUtil
 * @description TODO
 * @since 2022/2/5 15:47
 */
@Component
public class EmailUtil {

    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private MailProperties mailProperties;
    @Resource
    private TemplateEngine templateEngine;
    @Resource
    private DefaultKaptcha defaultKaptcha;

    public String sendMail(String email){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        String code = null;
        try {
            helper = new MimeMessageHelper(mimeMessage, true);
            helper.setSubject("这是一封测试邮件");
            helper.setFrom(mailProperties.getUsername());
            helper.setTo(email);
            helper.setSentDate(new Date());
            code = defaultKaptcha.createText();
            // 这里引入的是Template的Context
            Context context = new Context();
            // 设置模板中的变量
            context.setVariable("title", "游戏王综合服务平台");
            context.setVariable("mail",email);
            context.setVariable("code", code);
            // 第一个参数为模板的名称
            String process = templateEngine.process("mail.html", context);
            // 第二个参数true表示这是一个html文本
            helper.setText(process,true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return code;
    }
}
