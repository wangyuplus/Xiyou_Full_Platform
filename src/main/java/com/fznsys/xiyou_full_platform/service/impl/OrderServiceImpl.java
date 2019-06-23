package com.fznsys.xiyou_full_platform.service.impl;

import com.fznsys.xiyou_full_platform.mapper.OrderMapper;
import com.fznsys.xiyou_full_platform.pojo.Order;
import com.fznsys.xiyou_full_platform.pojo.OrderFood;
import com.fznsys.xiyou_full_platform.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@CacheConfig(cacheNames = "order", cacheManager = "cacheManager")
@Service
public class OrderServiceImpl implements OrderService {
   @Autowired
   OrderMapper orderMapper;


    @Override
    @Cacheable()
    public ArrayList<Order> getlistAll() {
        return orderMapper.findAll();
    }

    @Override
    public String insertorder(String userid, String sum, String mark){
        Order order=new Order();
        String id=UUID.randomUUID().toString();
        order.setId(id);
        order.setDate(DateFormat.getDateTimeInstance().format(new Date()));
        order.setUserid(userid);
        order.setSum(sum);
        order.setMark(mark);
         orderMapper.insert(order);
         return id;
    }

//    @Override
//    public void insertorder(OrderFood orderfood) {
//
//
//    }

    @Override
    @CacheEvict(key = "#id")
    public List<Order> deleteorder(String id) {
        return orderMapper.delete(id);
    }
    @Override
    @CacheEvict(key = "#id")
    public Order getOrderById(String id) {
        return orderMapper.selectById(id);
    }
}
