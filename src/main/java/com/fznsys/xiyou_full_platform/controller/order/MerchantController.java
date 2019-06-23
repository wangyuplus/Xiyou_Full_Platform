package com.fznsys.xiyou_full_platform.controller.order;

import com.alibaba.fastjson.JSONObject;
import com.fznsys.xiyou_full_platform.pojo.Merchant;
import com.fznsys.xiyou_full_platform.service.MerchantService;
import com.fznsys.xiyou_full_platform.util.LayuiJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @RequestMapping("/getmerchantlist")
    public JSONObject getlist(){
        return LayuiJSON.layuiJSON(merchantService.getlistAll());
    }

    @RequestMapping("/getmerchantById")
    public  Merchant getlist(String id){
        return merchantService.getMerchantById(id);
    }

    @RequestMapping("/insertmerchant")
    public String insertmerchant(Merchant merchant){
        String uuid=UUID.randomUUID().toString();
        merchant.setId(uuid);
         merchantService.insertMerchant(merchant);
        String msg = "成功";
        return msg;
    }

    @RequestMapping("/deletemerchantById")
    public void deletemerchant(String id){
        System.out.println(id);
        System.out.println("deletemerchantById");
         merchantService.deleteMerchant(id);
    }
}
