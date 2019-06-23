package com.fznsys.xiyou_full_platform.service;

import com.fznsys.xiyou_full_platform.pojo.Order;
import com.fznsys.xiyou_full_platform.pojo.OrderFood;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface OrderService {
    ArrayList<Order> getlistAll();

    String insertorder(String userid,String sum,String mark);

//    void insertorder(OrderFood orderfood);

    List<Order> deleteorder(String id);

    Order getOrderById(String id);

}
