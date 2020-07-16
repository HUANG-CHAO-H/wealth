package com.wealth.server.impl;

import com.wealth.mapper.userMapper;
import com.wealth.pojo.User;
import com.wealth.server.userServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServerImpl implements userServer {
    @Autowired
    private userMapper userMapper;

    @Override
    public Integer selectUserNumber() {
        return userMapper.selectUserNumber();
    }

    @Override
    public List<User> selectUserAll(int startID, int number) {
        return userMapper.selectUserAll(startID, number);
    }

    @Override
    public List<User> selectUserName(String value) {
        return userMapper.selectUserName(value);
    }
}
