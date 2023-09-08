package com.zrh.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PageBean<T> {
    private int cp; //当前页码
    private int ps;
    private long totalCount;
    private int totalPage;
    private List<T> list;

    public PageBean(int cp,int ps,long totalCount,List<T> list){
        this.cp = cp;
        this.ps = ps;
        this.totalCount = totalCount;
        this.totalPage = (int)(Math.ceil(totalCount*1.0 / ps));
        this.list = list;
    }
}
