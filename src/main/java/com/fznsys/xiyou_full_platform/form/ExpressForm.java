package com.fznsys.xiyou_full_platform.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author:罗云继
 * @date 2019/6/5 9:56
 */
@Data
public class ExpressForm {

    /**收件人姓名*/
    @NotEmpty(message = "收件人姓名必填")
    private String name;

    /**快递公司*/
    @NotEmpty(message = "快递公司必填")
    private String company;

    /**快递编号*/
    @NotEmpty(message = "快递编号必填")
    private String expressnum;

    /**联系电话*/
    @NotEmpty(message ="联系电话必填" )
    private String phonenumber;

    /**目的地址*/
    @NotEmpty(message ="目的地必填" )
    private String address;
}
