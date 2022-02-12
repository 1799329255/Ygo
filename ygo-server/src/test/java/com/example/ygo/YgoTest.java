package com.example.ygo;


import com.alibaba.fastjson.JSON;
import com.example.ygo.common.utils.EmailUtil;

import com.example.ygo.common.utils.MinioUtil;
import com.example.ygo.dao.*;
import com.example.ygo.entity.*;
import com.example.ygo.service.CardService;
import com.example.ygo.service.RoleService;
import com.example.ygo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


import java.util.Date;
import java.util.List;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class YgoTest
{
    @Resource
    private ArticleMapper articleMapper;

    @Test
    public void sendThymeleafMail() {

        //Long[] ids = {Long.valueOf(1), Long.valueOf(2)};
        List<Article> articles = articleMapper.findArticleInfoByExample(
                new ArticleExample()
                        .createCriteria()
                        .andUserIdEqualTo((long) 1)
                        .example().orderBy("id").page(0,3), null
        );
        System.out.println(JSON.toJSONString(new PageInfo<>(articles)));
    }
}
