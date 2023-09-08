package com.zrh.dao;

import com.zrh.pojo.Review;

public interface ReviewDao {
    //通过id获取review
    Review getReviewById(int reviewid);
}
