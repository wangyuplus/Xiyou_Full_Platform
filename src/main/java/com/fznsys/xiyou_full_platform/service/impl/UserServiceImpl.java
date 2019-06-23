package com.fznsys.xiyou_full_platform.service.impl;

import com.fznsys.xiyou_full_platform.mapper.UserMapper;
import com.fznsys.xiyou_full_platform.pojo.User;
import com.fznsys.xiyou_full_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@CacheConfig(cacheNames = "user", cacheManager = "cacheManager")
@Service
public class UserServiceImpl implements UserService {
    // 依赖注入
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser(String username) {

        return userMapper.findByUsername(username);
    }

    @Override
    @Cacheable()
    public User getUserById(String id) {
        System.out.println("getUserByIdService");
        return userMapper.findById(id);
    }


    @Override
    @Cacheable()
    public ArrayList<User> getAll() {
        System.out.println("Redis中无此数据");
        return userMapper.findAll();
    }

    @Override
//    @CachePut(key = "#user.id")
    public User update(User user) {
        System.err.println("执行这里，更新数据库，更新缓存....");
        userMapper.update(user);
        //ArrayList<User> userArrayList = userMapper.findAll();

        return user;

    }

    @Override
//    @CacheEvict(key = "#id")
    public String delete(String id) {
        System.err.println("执行这里，删除数据，更新缓存....");

        userMapper.delete(id);
        String msg ="成功";
        return msg;

    }

    @Override
    public String insert(User user) {
        userMapper.insert(user.getId(),user.getName(),user.getUsername(),user.getPassword(),user.getRole());

        return "成功";

    }

    @Override
    public User LoginByUsernameAndPassword(String username, String password) {
        return userMapper.LoginByUsernameAndPassword(username, password);
    }

    @Override
    public void insertAd(String uuid, String name, String username, String password, String role) {
        userMapper.insertAd(uuid,name,username,password,role);
    }

    @Override
    public void updateAd(String name, String username, String password, String role) {
        userMapper.updateAd(name,username,password,role);
    }
}
