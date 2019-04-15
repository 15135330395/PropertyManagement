package com.web.util;/*
 * @author :张
 * Date  : 2019/4/10
 * @Description: JsonUtil
 */

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.web.entity.PageBean;

import java.util.List;

public class JsonUtil {

    public static <T> JSONObject getJsonObject(List<T> list , PageBean pageBean) {
        Object jsonArr = JSONArray.toJSON(list);
        JSONObject array=new JSONObject();
        array.put("code",0);
        array.put("msg","");
        array.put("count",pageBean.getCount());
        array.put("data",jsonArr);
        return array;
    }

}
