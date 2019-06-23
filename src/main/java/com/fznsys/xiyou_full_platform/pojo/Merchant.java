package com.fznsys.xiyou_full_platform.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
//商家
public class Merchant implements Serializable {
    private  String id;
    private String name;
    private  String menuid;//菜单id
    private  String announcement;//公告
    private  String type;//营业状态


}
