package com.fznsys.xiyou_full_platform.util;

import com.alibaba.fastjson.JSONObject;

public class LayuiJSON {
    public static JSONObject layuiJSON(Object o){
        JSONObject rootObject = new JSONObject();
        rootObject.put("code", 0);
        rootObject.put("msg", "1");
        rootObject.put("count", 1000);
        rootObject.put("data",o);
        return rootObject;
    }
}
