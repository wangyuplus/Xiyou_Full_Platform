package com.fznsys.xiyou_full_platform.service.impl;

import com.fznsys.xiyou_full_platform.mapper.LifePaymentMapper;
import com.fznsys.xiyou_full_platform.pojo.LifePayment;
import com.fznsys.xiyou_full_platform.service.LifePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Autor:朱中雨
 * Date:2019-6-5
 * Target:
 */
@Service
public class LifePaymentImpl implements LifePaymentService {
    @Autowired
    private LifePaymentMapper lifePaymentMapper;
    @Override
    public String addLifePayment(String userid,String type,String num,String way,String mark) {
        LifePayment lifePayment=new LifePayment();
        String id=UUID.randomUUID().toString();
        lifePayment.setId(id);
        lifePayment.setUserid(userid);
        lifePayment.setType(type);
        lifePayment.setNum(num);
        lifePayment.setDate(DateFormat.getDateTimeInstance().format(new Date()));
        lifePayment.setMark(mark);
        lifePayment.setWay(way);
        lifePayment.setStatus("0");
        if(lifePaymentMapper.addPayment(lifePayment)>0)return id;
        return null;
    }

    @Override
    public boolean updateStatus(String id, String status) {
        if(lifePaymentMapper.updateStatusById(id,status)>0)return true;
        return false;
    }

    @Override
    public ArrayList<LifePayment> getLifePaymentByUserid(String userid) {
        return lifePaymentMapper.getLifePaymentByuserid(userid);
    }

    @Override
    public ArrayList<LifePayment> getLifePaymentByUseridAndType(String userid, String type) {
        return lifePaymentMapper.getLifePaymentByuseridAndtype(userid,type);
    }

    @Override
    public ArrayList<LifePayment> getLifePaymentByUseridAndStatus(String userid, String status) {
        return lifePaymentMapper.getLifePaymentByuseridAndstatus(userid,status);
    }

    @Override
    public LifePayment getLifePaymentById(String id) {
        return lifePaymentMapper.getLifePaymentByid(id);
    }
}
