package com.fznsys.xiyou_full_platform.controller.order;

import com.fznsys.xiyou_full_platform.pojo.OrderFood;
import com.fznsys.xiyou_full_platform.service.OrderFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderFoodController {

    @Autowired
    OrderFoodService orderFoodService;

    @RequestMapping("/getOrderFoodList")
    public List<OrderFood> getlist(){
        return orderFoodService.getlistAll();
    }

    @RequestMapping("/getOrderFoodById")
    public  OrderFood getlist(String id){
        return orderFoodService.getOrderFoodById(id);
    }

    @RequestMapping("/insertOrderFood")
    public List<OrderFood> insertorderFood(OrderFood orderFood){
        return orderFoodService.insertorderFood(orderFood);
    }
    @RequestMapping("/deleteOrderFood")
    public List<OrderFood> deleteorderFood(String id){
        return orderFoodService.deleteorderFood(id);
    }

}
