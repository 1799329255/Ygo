package com.example.ygo;


import com.example.ygo.common.utils.EmailUtil;

import com.example.ygo.common.utils.MinioUtil;
import com.example.ygo.dao.ArticleMapper;
import com.example.ygo.dao.CommentMapper;
import com.example.ygo.dao.RoleMapper;
import com.example.ygo.dao.UserMapper;
import com.example.ygo.entity.ArticleExample;
import com.example.ygo.entity.CommentExample;
import com.example.ygo.entity.User;
import com.example.ygo.service.RoleService;
import com.example.ygo.service.UserService;
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

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class YgoTest
{
    @Resource
    private CommentMapper commentMapper;

    @Test
    public void sendThymeleafMail() {
        System.out.println(commentMapper.findCommentInfoByExample(
                new CommentExample()
                        .createCriteria()
                        .andArticleIdEqualTo((long) 1)
                        .andLogicalDeleted(false)
                        .example()
        ));

    }
}
