package com.zrh.controller;

import com.zrh.dao.LostDao;
import com.zrh.dao.UserDao;
import com.zrh.pojo.BaseResp;
import com.zrh.pojo.Comment;
import com.zrh.pojo.Lost;
import com.zrh.pojo.User;
import com.zrh.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private LostDao lostDao;    //lost的dao层
    @Autowired
    private UserDao userDao;    //user的dao层

    @GetMapping("/getAllCommentsByLostId/{lostid}")
    @ResponseBody
    //根据丢失物品id获取有关物品的所有评论信息
    public BaseResp getAllCommentsByLostId(@PathVariable("lostid") int lostid){
        List<Comment> comments = commentService.getAllCommentsByLostId(lostid);
        BaseResp baseResp = new BaseResp();
        baseResp.setCode(0);
        baseResp.setMsg("");
        baseResp.setData(comments);
        return baseResp;
    }

    @PostMapping("/addComment")
    @ResponseBody
    //添加评论信息的方法
    public BaseResp addComment(HttpServletRequest request){
        //接收lostid 并根据lostid获取对应的lost对象
        String slostid = request.getParameter("lostid");
        int lostid = Integer.parseInt(slostid);
        Lost lost = lostDao.getLostById(lostid);

        //接收userid 并根据接收userid获取对应的user对象
        String suserid = request.getParameter("userid");
        int userid = Integer.parseInt(suserid);
        User user = userDao.getUserById(userid);

        //创建comment对象并将相关数据存进对象中
        String ccontent = request.getParameter("content");
        try {
            ccontent = new String(ccontent.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(ccontent);

        Comment comment = new Comment();
        comment.setCcontent(ccontent);
        comment.setLost(lost);
        comment.setUser(user);
        comment.setCommenttime(new Date());

//        调用CommentService的添加评论方法,成功就调用getAllCommentsByLostId方法将该物品的评论渲染，否则就不调用
        boolean b = commentService.addComment(comment);
        if(b){
           return getAllCommentsByLostId(lostid);
        }
        return null;
    }
}
