package com.fznsys.xiyou_full_platform.controller.order;

import com.alibaba.fastjson.JSONObject;
import com.fznsys.xiyou_full_platform.pojo.Food;
import com.fznsys.xiyou_full_platform.pojo.Order;
import com.fznsys.xiyou_full_platform.pojo.User;
import com.fznsys.xiyou_full_platform.service.OrderService;
import com.fznsys.xiyou_full_platform.util.LayuiJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;


    @RequestMapping("/getorderlist")
    public JSONObject getlist(){
        List<Order> orders= orderService.getlistAll();

        String a=null;
        Double money = 0.0;
        for (int i=0;i<orders.size();i++){

            a=a+"+"+orders.get(i).getId();

        }
        System.out.println(a);
        String date = orders.get(0).getDate();
        String mark = orders.get(0).getMark();
        JSONObject jsonObject=LayuiJSON.layuiJSON( orderService.getlistAll());
        jsonObject.put("data",a);
        jsonObject.put("money",money);
        jsonObject.put("date",date);
        jsonObject.put("mark",mark);
        System.out.println(jsonObject);
        return LayuiJSON.layuiJSON( orderService.getlistAll());


    }
    @RequestMapping("/getorderById")
    public  Order getlist(String id){
        return orderService.getOrderById(id);
    }

    @RequestMapping("/insertorder")
    public void insertorder(HttpServletRequest request,String data){
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");
        System.out.println("sessonuser"+user);
        //String orderid=orderService.insertorder(user.getId(),sum,mark);
    String a[]=data.split("-");

    for (int i=0;i<a.length;i++){
        System.out.println(a[i]);
        //orderService.insertorder(a[i]);
        //orderService.insertorder();
    }


    }
    @RequestMapping("/deleteorderById")
    public List<Order> deleteorder(String id){
        return orderService.deleteorder(id);
    }

}
