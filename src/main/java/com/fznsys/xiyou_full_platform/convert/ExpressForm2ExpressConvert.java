package com.fznsys.xiyou_full_platform.convert;

import com.alibaba.fastjson.JSONObject;
import com.fznsys.xiyou_full_platform.form.ExpressForm;
import com.fznsys.xiyou_full_platform.pojo.Express;

import java.util.ArrayList;

/**
 * @author:罗云继
 * @date 2019/6/5 10:16
 */
public class ExpressForm2ExpressConvert {
    public static Express convert(ExpressForm expressForm){
        Express express=new Express();

        express.setRecivename(expressForm.getName());
        express.setCompany(expressForm.getCompany());
        express.setExpressnum(expressForm.getExpressnum());
        express.setPhonenumber(expressForm.getPhonenumber());
        express.setAddress(expressForm.getAddress());

        return express;
    }
//    Gson gson = new Gson();
//    OrderDTO orderDTO=new OrderDTO();
//
//        orderDTO.setBuyerName(orderForm.getName());
//        orderDTO.setBuyerPhone(orderForm.getPhone());
//        orderDTO.setBuyerAddress(orderForm.getAddress());
//        orderDTO.setBuyerOpenid(orderForm.getOpenid());
//
//    List<OrderDetail> orderDetailList=new ArrayList<>();
//        try {
//        orderDetailList=gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
//        }.getType());
//    }catch (Exception e){
//        log.error("【对象转换】 错误，string={}",orderForm.getItems());
//        throw new SellException(ResultEnum.PARAM_ERROR);
//    }
//        orderDTO.setOrderDetailList(orderDetailList);

}
