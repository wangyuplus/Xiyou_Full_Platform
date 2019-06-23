package com.fznsys.xiyou_full_platform.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.fznsys.xiyou_full_platform.pojo.User;
import com.fznsys.xiyou_full_platform.service.UserService;
import com.fznsys.xiyou_full_platform.util.LayuiJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.UUID;


@RestController // 声明这是Controller层
public class UserController {

    // 依赖注入
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login")
    public User login(User user, HttpServletRequest request) {
        // 调用dao层
        HttpSession session=request.getSession();
        User us=userService.LoginByUsernameAndPassword(user.getUsername(),user.getPassword());
        if(us!=null)
        {
            session.setAttribute("user",us);
        }
        return us;
//        System.out.println("前端" + user);
//        User u = userService.getUser(user.getUsername());
//        System.out.println("数据库" + u);
//        if (u.getPassword().equals(user.getPassword())) {
//            return u;
//        }
//        return null;
    }

    @RequestMapping(value = "/loginout", method = RequestMethod.POST)
    public String loginout(HttpServletRequest request) {
        // 调用dao层
        HttpSession session=request.getSession();
        if(session.getAttribute("user")!=null)
        {
            session.setAttribute("user",null);
            return "true";
        }
        return "false";
//        System.out.println("前端" + user);
//        User u = userService.getUser(user.getUsername());
//        System.out.println("数据库" + u);
//        if (u.getPassword().equals(user.getPassword())) {
//            return u;
//        }
//        return null;
    }

    @RequestMapping(value = "/getUser")
     public JSONObject getAll() {
        ArrayList userList = userService.getAll();
        return LayuiJSON.layuiJSON(userList);
        /*JSONObject rootObject = new JSONObject();
        rootObject.put("code", 0);
        rootObject.put("msg", "");
        rootObject.put("count", 1000);
        rootObject.put("date",userList);
        return rootObject;*/
    }
    @RequestMapping(value = "/getname")
    public String getname(HttpServletRequest request) {
        if(((User)request.getSession().getAttribute("user"))!=null)
       return ((User)request.getSession().getAttribute("user")).getName();
        return null;
        /*JSONObject rootObject = new JSONObject();
        rootObject.put("code", 0);
        rootObject.put("msg", "");
        rootObject.put("count", 1000);
        rootObject.put("date",userList);
        return rootObject;*/
    }
    @RequestMapping(value = "/getUserById")

    public JSONObject getUserById(String id) {

        User user = userService.getUserById(id);

        return LayuiJSON.layuiJSON(user);
    }

    @RequestMapping(value = "/deleteUser")

    public String delete(String id) {
        System.out.println(id);
        User user = new User();
        user.setId(id);
        String msg = userService.delete(id);
        return msg;

    }

    @RequestMapping(value = "/updateUser")
    public void update(String id) {
        User user = new User();
        user.setId(id);
        user.setUsername("111");
        user.setPassword("111");
        user.setRole("www");
        userService.update(user);


    }

    @RequestMapping(value = "/insertUser")

    public String insert(User user) {

        String uuid= UUID.randomUUID().toString();
        user.setId(uuid);
        System.out.println(user);
        userService.insert(user);
        String msg = "成功";
        return msg;
    }
    @RequestMapping(value = "/addUser")

    public String insertAd(String name,String username,String password,String role) {

        String uuid= UUID.randomUUID().toString();
        userService.insertAd(uuid,name,username,password,role);
        String msg = "成功";
        return msg;
    }

    @RequestMapping(value = "/updateAdUser")
    public void updateAd(String name,String username,String password,String role) {

        userService.updateAd(name,username,password,role);


    }
}
