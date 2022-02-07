package com.example.ygo.dao;

import com.example.ygo.entity.Comment;
import com.example.ygo.entity.CommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper extends BaseMapper<Comment,Long,CommentExample>{

    List<Comment> findCommentInfoByExample(CommentExample commentExample);

}