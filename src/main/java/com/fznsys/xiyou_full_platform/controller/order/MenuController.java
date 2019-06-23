package com.fznsys.xiyou_full_platform.controller.order;

import com.fznsys.xiyou_full_platform.pojo.Menu;
import com.fznsys.xiyou_full_platform.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {
@Autowired
    MenuService menuService;

    @RequestMapping("/getmenulist")

    public List<Menu> getlist(){
        return menuService.getlistAll();
    }
    @RequestMapping("/getMenuById")
    public  Menu getlist(String id){
        return menuService.getMenuById(id);
    }

    @RequestMapping("/insertMenu")
    public List<Menu> insertorder(Menu menu){
        return menuService.insertMenu(menu);
    }
    @RequestMapping("/deleteMenuById")
    public List<Menu> deleteorder(String id){
        return menuService.deleteMenu(id);
    }
}
