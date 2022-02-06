package com.example.ygo.dao;

import com.example.ygo.entity.Article;
import com.example.ygo.entity.ArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleMapper extends BaseMapper<Article,Long,ArticleExample>{

    List<Article> findArticleInfoByExample(ArticleExample articleExample);
}