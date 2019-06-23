package com.fznsys.xiyou_full_platform.service.impl;

import com.fznsys.xiyou_full_platform.mapper.FoodMapper;
import com.fznsys.xiyou_full_platform.mapper.MenuMapper;
import com.fznsys.xiyou_full_platform.mapper.MerchantMapper;
import com.fznsys.xiyou_full_platform.pojo.Food;
import com.fznsys.xiyou_full_platform.pojo.Menu;
import com.fznsys.xiyou_full_platform.pojo.Merchant;
import com.fznsys.xiyou_full_platform.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodMapper foodMapper;
    @Autowired
    MerchantMapper merchantMapper;
    @Autowired
    MenuMapper menuMapper;


    @Override
    public ArrayList<Food> getlistAll() {
        return foodMapper.select();
    }

    @Override
    public List<Food> insertfood(Food food) {
        return foodMapper.insert(food);
    }

    @Override
    public List<Food> deletefood(String id) {
        return foodMapper.delete(id);
    }

    @Override
    public List<Food> getFoodById(String id) {
        return foodMapper.selectByFoodId(id);
    }

    @Override
    public List<String> getFoodIdById(String id) {
        System.out.println(id);
        Merchant merchant1=  merchantMapper.selectByMerchantId2(id);

List<Merchant> merchant=new ArrayList<>();
merchant.add(merchant1);
        System.out.println(merchant1);
        System.out.println(merchant);
        List<String> menuid = new ArrayList();

        List<String> food = new ArrayList();
List<Menu> menus=new ArrayList<>();

        for (int i=0;i<(merchant.size());i++) {

            System.out.println(merchant.get(i));
                  menuid.add(merchant.get(i).getMenuid());
        }
        System.out.println(menuid);
        for (int i=0;i<(menuid.size());i++) {
            Menu menu=menuMapper.selectByMenuId(menuid.get(i));
            menus.add(menu);
            food.add(menus.get(i).getFoodid());
        }

        System.out.println(food);

        return food;
    }
}
