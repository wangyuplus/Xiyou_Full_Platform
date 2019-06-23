package com.fznsys.xiyou_full_platform.service;

import com.fznsys.xiyou_full_platform.pojo.Order;
import com.fznsys.xiyou_full_platform.pojo.OrderFood;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public  interface OrderFoodService {
    ArrayList<OrderFood> getlistAll();

    List<OrderFood> insertorderFood(OrderFood orderFood);

    List<OrderFood> deleteorderFood(String id);

    OrderFood getOrderFoodById(String id);
}
