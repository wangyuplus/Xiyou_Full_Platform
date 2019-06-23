package com.fznsys.xiyou_full_platform.service;

import com.fznsys.xiyou_full_platform.pojo.Menu;
import com.fznsys.xiyou_full_platform.pojo.OrderFood;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface MenuService {
    ArrayList<Menu> getlistAll();

    List<Menu> insertMenu(Menu menu);

    List<Menu> deleteMenu(String id);

    Menu getMenuById(String id);
}
