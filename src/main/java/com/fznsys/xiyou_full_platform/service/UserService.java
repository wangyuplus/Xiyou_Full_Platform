package com.fznsys.xiyou_full_platform.service;

import com.fznsys.xiyou_full_platform.pojo.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface UserService {
    User getUser(String username);

    ArrayList<User> getAll();

    User update(User user);

    String delete(String id);

    String insert(User user);

    User getUserById(String id);


    User LoginByUsernameAndPassword(String username,String password);

    void insertAd(String uuid, String name, String username, String password, String role);

    void updateAd(String name, String username, String password, String role);
}
