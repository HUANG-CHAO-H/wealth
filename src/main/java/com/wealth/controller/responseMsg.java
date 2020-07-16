package com.wealth.controller;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class responseMsg {
    private String code;
    private Map<String,Object> extend;

    public static responseMsg success() {
        responseMsg mes = new responseMsg();
        mes.extend = new HashMap<>();
        mes.code = "SUCCESS";
        return mes;
    }

    public static responseMsg failure(String reason) {
        responseMsg mes = new responseMsg();
        mes.extend = new HashMap<>();
        mes.code = "FAILURE";
        mes.extend.put("reason",reason);
        return mes;
    }

    public static responseMsg error(String reason) {
        responseMsg mes = new responseMsg();
        mes.extend = new HashMap<>();
        mes.code = "ERROR";
        mes.extend.put("reason",reason);
        return mes;
    }

    public responseMsg add(String key, Object obj) {
        extend.put(key, obj);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                "\"code\":\"" + code + '\"' +
                ", \"extend\":" + JSONObject.toJSONString(extend) +
                '}';
    }
}
