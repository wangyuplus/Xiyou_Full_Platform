package com.fznsys.xiyou_full_platform.controller.paymentoflife;

import com.alibaba.fastjson.JSONObject;
import com.fznsys.xiyou_full_platform.pojo.LifePayment;
import com.fznsys.xiyou_full_platform.pojo.User;
import com.fznsys.xiyou_full_platform.service.LifePaymentService;
import com.fznsys.xiyou_full_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Author:朱中雨
 * Date:2019-6-5
 * Target:
 * 缴费状态：0缴费中
 *          1缴费成功
 *          2缴费失败
 * 缴费类型：0电费
 *          1水费
 *          2话费
 *          3网费
 *          4一卡通
 */
@Controller
public class PaymentOfLifeController {
    @Autowired
    private LifePaymentService lifePaymentService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getlifetest")
    @ResponseBody
    public JSONObject getlifetest(HttpServletRequest request)
    {
        if(request.getSession().getAttribute("user")==null)
        {
            JSONObject rootObject = new JSONObject();
            rootObject.put("code", 0);
            rootObject.put("msg", "");
            rootObject.put("count", 0);
            rootObject.put("data", null);
            return rootObject;
        }

        User user=(User)request.getSession().getAttribute("user");
        ArrayList<LifePayment> list = lifePaymentService.getLifePaymentByUserid(user.getId());
        for (LifePayment lp:
             list) {
            int index=list.indexOf(lp);
            lp.setUserid(user.getName());
            list.set(index,lp);
        }
        JSONObject rootObject = new JSONObject();
        rootObject.put("code", 0);
        rootObject.put("msg", "");
        rootObject.put("count", list.size());
        rootObject.put("data", list);

        return rootObject;
    }

    @RequestMapping(value = "/payforelectricitya")
    @ResponseBody
    public String payforelectricitya(HttpServletRequest request, LifePayment lifePayment)//电费缴纳
    {
        HttpSession session=request.getSession();
        String id=null;
        if(session.getAttribute("user")!=null)
        {
            User user=(User)session.getAttribute("user");
            id=lifePaymentService.addLifePayment(user.getId(),"0",lifePayment.getNum(),lifePayment.getWay(),"");
            lifePaymentService.updateStatus(id,"1");
            session.setAttribute("lifepaymentid",id);
        }
        return id;
    }

    @RequestMapping(value = "/payforwatera")
    @ResponseBody
    public String payforwatera(HttpServletRequest request, LifePayment lifePayment)//水费缴纳
    {
        HttpSession session=request.getSession();
        String id=null;
        if(session.getAttribute("user")!=null)
        {
            User user=(User)session.getAttribute("user");
            id=lifePaymentService.addLifePayment(user.getId(),"1",lifePayment.getNum(),lifePayment.getWay(),"");
            lifePaymentService.updateStatus(id,"1");
            session.setAttribute("lifepaymentid",id);
        }

        return id;
    }

    @RequestMapping(value = "/payforphonea")
    @ResponseBody
    public String payforphonea(HttpServletRequest request, LifePayment lifePayment)//话费缴纳
    {
        HttpSession session=request.getSession();
        String id=null;
        if(session.getAttribute("user")!=null)
        {
            User user=(User)session.getAttribute("user");
            id=lifePaymentService.addLifePayment(user.getId(),"2",lifePayment.getNum(),lifePayment.getWay(),"");
            lifePaymentService.updateStatus(id,"1");
            session.setAttribute("lifepaymentid",id);
        }

        return id;
    }

    @RequestMapping(value = "/payforinterneta")
    @ResponseBody
    public String payforinterneta(HttpServletRequest request, LifePayment lifePayment)//网费缴纳
    {
        HttpSession session=request.getSession();
        String id=null;
        if(session.getAttribute("user")!=null)
        {
            User user=(User)session.getAttribute("user");
            id=lifePaymentService.addLifePayment(user.getId(),"3",lifePayment.getNum(),lifePayment.getWay(),"");
            lifePaymentService.updateStatus(id,"1");
            session.setAttribute("lifepaymentid",id);
        }

        return id;
    }

    @RequestMapping(value = "/payforcarda")
    @ResponseBody
    public String payforcarda(HttpServletRequest request, LifePayment lifePayment)//一卡通充值
    {
        HttpSession session=request.getSession();
        String id=null;
        if(session.getAttribute("user")!=null)
        {
            User user=(User)session.getAttribute("user");
            id=lifePaymentService.addLifePayment(user.getId(),"4",lifePayment.getNum(),lifePayment.getWay(),"");
            lifePaymentService.updateStatus(id,"1");
            session.setAttribute("lifepaymentid",id);
        }

        return id;
    }

    @RequestMapping(value = "/paymentresult")
    @ResponseBody
    public JSONObject paymentresult(HttpServletRequest request)
    {
        HttpSession session=request.getSession();
        String id;
        ArrayList<LifePayment> list = new ArrayList<LifePayment>();
        JSONObject rootObject = new JSONObject();
        rootObject.put("code", 0);
        rootObject.put("msg", "");
        id=(String)session.getAttribute("lifepaymentid");
        if(id!=null)
        {
            LifePayment lp=lifePaymentService.getLifePaymentById(id);
            lp.setUserid(userService.getUserById(lp.getUserid()).getName());
            list.add(lp);
        }
        rootObject.put("count", list.size());
        rootObject.put("data", list);
        return rootObject;
    }

}
