package com.zrh.service;

import com.zrh.pojo.Comment;

import java.util.List;

public interface CommentService {
    //根据lostid获取所有有关这个物品的评论
    List<Comment> getAllCommentsByLostId(int lostid);

    //添加用户评论的方法
    boolean addComment(Comment comment);
}
