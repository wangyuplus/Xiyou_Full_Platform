package com.fznsys.xiyou_full_platform.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class Food implements Serializable {
    private static final long serialVersionUID = 6515261573146253923L;
    private  String id;
    private  String name;
    private String  off;//是否优惠
    private  String  price;//价格
    private  String offprice;//优惠后价格
    private  String status;//菜品状态

}
