package com.example.ygo;


import com.alibaba.fastjson.JSON;
import com.example.ygo.common.utils.EmailUtil;

import com.example.ygo.common.utils.MinioUtil;
import com.example.ygo.dao.*;
import com.example.ygo.entity.*;
import com.example.ygo.service.ArticlecategoryService;
import com.example.ygo.service.CardService;
import com.example.ygo.service.RoleService;
import com.example.ygo.service.UserService;
import com.github.pagehelper.PageHelper;
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
    @Resource
    private EmailUtil emailUtil;
    @Resource
    private ArticlecategoryService articlecategoryService;

    @Test
    public void getArticles() {

        Long[] ids = {Long.valueOf(1), Long.valueOf(2)};

        ArticleExample articleExample = new ArticleExample()
                .createCriteria()
                .andUserIdEqualTo((long) 1)
                .example().orderBy("id").page(1, 3);
        long total = articleMapper.countByExample(articleExample);
        List<Article> articles = articleMapper.findArticleInfoByExample(
                articleExample, ids
        );
        PageInfo<Article> pageInfo = new PageInfo<>(articles, 1, 3, total);
        System.out.println(pageInfo);
        System.out.println(JSON.toJSONString(pageInfo));
    }

    @Test
    public void sendEmail(){
        String s = emailUtil.sendMail("1799329255@qq.com");
        System.out.println(s);
    }

    @Test
    public void findArticlecategories(){
        Articlecategory articlecategory = new Articlecategory();
        articlecategory.setName("卡");
        PageInfo<Articlecategory> articlecategories = articlecategoryService.findArticlecategoryInfoPage(articlecategory, "id", 1, 5);
        System.out.println(articlecategories);
    }


}
