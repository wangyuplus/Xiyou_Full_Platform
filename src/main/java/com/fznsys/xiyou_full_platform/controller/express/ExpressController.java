package com.fznsys.xiyou_full_platform.controller.express;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fznsys.xiyou_full_platform.convert.ExpressForm2ExpressConvert;
import com.fznsys.xiyou_full_platform.form.ExpressForm;
import com.fznsys.xiyou_full_platform.pojo.Express;
import com.fznsys.xiyou_full_platform.pojo.User;
import com.fznsys.xiyou_full_platform.service.ExpressService;
import com.fznsys.xiyou_full_platform.service.UserService;
import com.fznsys.xiyou_full_platform.util.LayuiJSON;
import com.fznsys.xiyou_full_platform.vo.ExpressVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * @author:罗云继
 * @date 2019/6/4 10:56
 */
@RestController
@RequestMapping("/express")
@Slf4j
public class ExpressController {

    @Autowired
    private ExpressService expressService;


    @RequestMapping("/findAll")
    public JSONObject findAll(){

        ArrayList<Express> expressArrayList = expressService.findAll();

        ArrayList<ExpressVO> expressVOArrayList=new ArrayList<>();
        for (Express express : expressArrayList) {
            ExpressVO expressVO = new ExpressVO();

            BeanUtils.copyProperties(express,expressVO);

            expressVOArrayList.add(expressVO);
        }

        return LayuiJSON.layuiJSON(expressVOArrayList);
    }

    @RequestMapping("/insert")
    public ResponseEntity insertExpress(@Valid ExpressForm expressForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("[创建订单] 参数不正确");
        }
        System.out.println(expressForm.toString());
        Express express = ExpressForm2ExpressConvert.convert(expressForm);

        expressService.addExpress(express);
        return ResponseEntity.ok(0);
    }

    @RequestMapping("/delete")
    public ResponseEntity deleteExpress(@RequestParam("id") String id){
        expressService.deleteExpress(id);
        return ResponseEntity.ok(0);
    }

    @RequestMapping("/findByName")
    public JSONObject findByName(String name){
        Express express = expressService.findByName(name);
        ExpressVO expressVO=new ExpressVO();
        BeanUtils.copyProperties(express,expressVO);
        return LayuiJSON.layuiJSON(expressVO);

    }
}
