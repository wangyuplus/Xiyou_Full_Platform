package com.fznsys.xiyou_full_platform;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author:朱中雨
 * Date:2019-6-5
 * Target:页面测试
 */
@Controller
@Ignore
public class testController {
    @RequestMapping("/index")
    public String index()
    {
        return "index";
    }
}
