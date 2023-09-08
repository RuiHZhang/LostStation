package com.zrh.service.impl;

import com.zrh.dao.CommentDao;
import com.zrh.pojo.Comment;
import com.zrh.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> getAllCommentsByLostId(int lostid) {
        return commentDao.getCommentsByLostId(lostid);
    }

    @Override
    public boolean addComment(Comment comment) {
        int i = commentDao.addComment(comment);
        return i > 0;
    }
}
