package com.fznsys.xiyou_full_platform.service.impl;

import com.fznsys.xiyou_full_platform.mapper.ExpressMapper;
import com.fznsys.xiyou_full_platform.mapper.UserMapper;
import com.fznsys.xiyou_full_platform.pojo.Express;
import com.fznsys.xiyou_full_platform.service.ExpressService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author:罗云继
 * @date 2019/6/4 10:32
 */
@Service
public class ExpressServiceImpl implements ExpressService {

    @Autowired
    private ExpressMapper expressMapper;

    @Override
    public ArrayList<Express> findAll() {
        return expressMapper.findAll();
    }

    @Override
    public ArrayList<Express> findAlreadyTakenExpress() {
        return expressMapper.findAlreadyTakenExpress();
    }

    @Override
    public ArrayList<Express> findNotTakenExpress() {
        return expressMapper.findNotTakenExpress();
    }

    @Override
    public Express findExpressByNum(String num) {
        return expressMapper.findExpressByNum(num);
    }

    @Override
    @Transactional
    public void addExpress(Express express) {
        express.setId(UUID.randomUUID().toString());
        expressMapper.addExpress(express);
    }

    @Override
    @Transactional
    public void deleteExpress(String id) {
        expressMapper.deleteExpress(id);
    }

    @Override
    public Express findByName(String name) {
        return expressMapper.findByName(name);
    }
}
