package com.fznsys.xiyou_full_platform.service;

import com.fznsys.xiyou_full_platform.pojo.Express;

import java.util.ArrayList;

/**
 * @author:罗云继
 * @date 2019/6/4 10:30
 */
public interface ExpressService {
    ArrayList<Express> findAll();

    ArrayList<Express> findAlreadyTakenExpress();

    ArrayList<Express> findNotTakenExpress();

    Express findExpressByNum(String num);

    void addExpress(Express express);

    void deleteExpress(String id);

    Express findByName(String name);
}
