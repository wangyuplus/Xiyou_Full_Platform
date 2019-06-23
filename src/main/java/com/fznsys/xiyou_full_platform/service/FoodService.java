package com.fznsys.xiyou_full_platform.service;

import com.fznsys.xiyou_full_platform.pojo.Food;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface FoodService {

    ArrayList<Food> getlistAll();

    List<Food> insertfood(Food food);

    List<Food> deletefood(String id);

    List<Food> getFoodById(String id);

    List getFoodIdById(String id);
}
