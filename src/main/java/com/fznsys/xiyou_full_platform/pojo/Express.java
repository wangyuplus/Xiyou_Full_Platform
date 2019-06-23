package com.fznsys.xiyou_full_platform.pojo;

import lombok.Data;

/**
 * @author:罗云继
 * @date 2019/6/4 9:47
 */
@Data
public class Express {
    /**快递单id*/
    private String id;
    /**收件人id*/
    private String reciveid;
    /**用户电话*/
    private String phonenumber;
    /**收件人姓名*/
    private String recivename;
    /**快递公司*/
    private String company;
    /**收件人地址*/
    private String address;
    /**快递编号*/
    private String expressnum;
    /**快递员id*/
    private String courierid;
    /**快递员姓名*/
    private String couriername="暂无";
    /**价格*/
    private String price;
    /**快递状态*/
    private String status="0";
}
