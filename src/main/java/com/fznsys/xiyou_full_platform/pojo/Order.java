package com.fznsys.xiyou_full_platform.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {
    private String id;
    private  String userid;
    private  String date;
    private  String sum;
    private  String mark;

}
