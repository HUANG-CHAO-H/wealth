package com.wealth.controller;

import com.alibaba.fastjson.JSONObject;

public class requestMsg {
    private String requestString;
    private JSONObject requestObject;

    /**
     * 构造函数
     * @param requestString String类型的请求体
     */
    public requestMsg(String requestString) {
        this.requestString = requestString;
        requestObject = JSONObject.parseObject(requestString);
    }

    /**
     * 获取对象类型的成员
     * @param key   属性名称
     * @return
     */
    public Object getObject(String key) {
        return requestObject.get(key);
    }

    /**
     * 获取String类型的成员（进行类型转换）
     * @param key   属性名称
     * @return
     */
    public String getString(String key) {
        return requestObject.get(key).toString();
    }
}
