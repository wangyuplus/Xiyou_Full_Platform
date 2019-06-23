package com.fznsys.xiyou_full_platform.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author:罗云继
 * @date 2019/6/4 12:13
 */
@Data
public class ExpressVO {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String recivename;

    @JsonProperty("company")
    private String company;

    @JsonProperty("expressnum")
    private String expressnum;

    @JsonProperty("phonenumber")
    private String phonenumber;

    @JsonProperty("address")
    private String address;


    @JsonProperty("courierid")
    private String courierid;

    @JsonProperty("courier")
    private String couriername;

    @JsonProperty("status")
    private String status;


}
