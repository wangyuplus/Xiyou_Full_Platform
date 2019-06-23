package com.fznsys.xiyou_full_platform.controller.order;

import com.alibaba.fastjson.JSONObject;
import com.fznsys.xiyou_full_platform.pojo.Food;
import com.fznsys.xiyou_full_platform.service.FoodService;
import com.fznsys.xiyou_full_platform.util.LayuiJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {
    @Autowired
    FoodService foodService;

    @RequestMapping("/getfoodlist")
    public JSONObject getlist(){

        return LayuiJSON.layuiJSON(foodService.getlistAll());
    }

    @RequestMapping("/getfoodById")
    public  JSONObject  getlist(String id){

        return LayuiJSON.layuiJSON(foodService.getFoodById(id));
    }

    @RequestMapping("/insertfood")
    public List<Food> insertfood(Food food){
        return foodService.insertfood(food);
    }

    @RequestMapping("/deletefoodById")
    public List<Food> deletefood(String id){
        return foodService.deletefood(id);
    }

    @RequestMapping("/getFoodIdByMerchantId")
    public JSONObject getFoodIdByMerchantId(String id){

        return LayuiJSON.layuiJSON(foodService.getFoodIdById(id));
    }
}
