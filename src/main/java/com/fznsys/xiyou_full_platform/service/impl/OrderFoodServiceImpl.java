package com.fznsys.xiyou_full_platform.service.impl;

import com.fznsys.xiyou_full_platform.mapper.OrderFoodMapper;
import com.fznsys.xiyou_full_platform.mapper.OrderMapper;
import com.fznsys.xiyou_full_platform.pojo.Order;
import com.fznsys.xiyou_full_platform.pojo.OrderFood;
import com.fznsys.xiyou_full_platform.service.OrderFoodService;
import com.fznsys.xiyou_full_platform.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@CacheConfig(cacheNames = "orderfood", cacheManager = "cacheManager")
@Service
public class OrderFoodServiceImpl implements OrderFoodService {
@Autowired
    OrderFoodMapper orderFoodMapper;

    @Override
    @Cacheable()
    public ArrayList<OrderFood> getlistAll() {
        return orderFoodMapper.select();
    }

    @Override
    public List<OrderFood> insertorderFood(OrderFood orderFood) {
        return orderFoodMapper.insert(orderFood);
    }



    @Override
    public List<OrderFood> deleteorderFood(String id) {
        return orderFoodMapper.delete(id);
    }

    @Override
    public OrderFood getOrderFoodById(String id) {
        return orderFoodMapper.selectById(id);
    }
}
