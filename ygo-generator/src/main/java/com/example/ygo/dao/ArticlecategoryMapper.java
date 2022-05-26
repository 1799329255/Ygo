package com.example.ygo.dao;

import com.example.ygo.entity.Articlecategory;
import com.example.ygo.entity.ArticlecategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlecategoryMapper extends BaseMapper<Articlecategory,Long,ArticlecategoryExample>{

    List<Articlecategory> findArticleCategoryInfoByExample(ArticlecategoryExample articlecategoryExample);
}