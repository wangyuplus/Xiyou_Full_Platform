package com.fznsys.xiyou_full_platform.pojo;

import lombok.Data;

/**
 * Author:朱中雨
 * Date:2019-6-5
 * Target:
 */
@Data
public class LifePayment {
    private String id;//缴费单id

    private String userid;//用户id

    private String type;//缴费类型

    private String num;//缴费金额

    private String date;//缴费单时间

    private String status;//缴费单状态

    private String way;

    private String mark;//备注
}
