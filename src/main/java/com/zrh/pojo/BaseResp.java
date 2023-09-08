package com.zrh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResp {
    private Integer code;
    private String msg;
    private Object data;
    private String file;
    private Long total;

    public BaseResp SUCCESS(){
        return new BaseResp(1,"success",null,null,null);
    }

    public BaseResp Error(){
        return new BaseResp(0,"error",null,null,null);
    }
}
