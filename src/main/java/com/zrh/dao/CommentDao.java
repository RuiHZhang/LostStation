package com.zrh.dao;

import com.zrh.pojo.Comment;

import java.util.List;

public interface CommentDao {
    //根据丢失物品的id找到关于这个物品的所有评论
    List<Comment> getCommentsByLostId(int lostid);

    //添加用户评论的方法
    int addComment(Comment comment);
}
