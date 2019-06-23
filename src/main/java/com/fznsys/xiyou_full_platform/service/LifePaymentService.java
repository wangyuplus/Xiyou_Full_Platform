package com.fznsys.xiyou_full_platform.service;

import com.fznsys.xiyou_full_platform.pojo.LifePayment;

import java.util.ArrayList;

/**
 * Autor:朱中雨
 * Date:2019-6-5
 * Target:
 */
public interface LifePaymentService {
    String addLifePayment(String userid,String type,String num,String way,String mark) ;//新增缴费单,返回缴费单ID

    boolean updateStatus(String id,String status);//通过缴费单id更新状态

    ArrayList<LifePayment> getLifePaymentByUserid(String userid);//通过用户id获取所有缴费单

    ArrayList<LifePayment> getLifePaymentByUseridAndType(String userid,String type);//获取某一用户某一类型的缴费单

    ArrayList<LifePayment> getLifePaymentByUseridAndStatus(String userid,String status);//获取某一用户某一状态的缴费单

    LifePayment getLifePaymentById(String id);//通过缴费单id获取缴费单

}
