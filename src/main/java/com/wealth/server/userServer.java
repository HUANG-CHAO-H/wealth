package com.wealth.server;

import com.wealth.pojo.User;

import java.util.List;

public interface userServer {
    // 查询数据表中的数据条数
    public Integer selectUserNumber();
    // 按id范围批量查询用户
    public List<User> selectUserAll(int startID,int number);
    // 查询用户名称
    public List<User> selectUserName(String value);
}
