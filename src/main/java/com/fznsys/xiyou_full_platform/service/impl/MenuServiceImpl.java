package com.fznsys.xiyou_full_platform.service.impl;

import com.fznsys.xiyou_full_platform.mapper.MenuMapper;
import com.fznsys.xiyou_full_platform.pojo.Menu;
import com.fznsys.xiyou_full_platform.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuMapper menuMapper;
    @Override
    public ArrayList<Menu> getlistAll() {
        System.out.println("menulistService");
        return menuMapper.select();
    }

    @Override
    public List<Menu> insertMenu(Menu menu) {
        return menuMapper.insert(menu);
    }

    @Override
    public List<Menu> deleteMenu(String id) {
        return menuMapper.delete(id);
    }

    @Override
    public Menu getMenuById(String id) {
        return menuMapper.selectByMenuId(id);
    }
}
