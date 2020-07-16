package com.wealth.server.impl;

import com.wealth.mapper.adminMapper;
import com.wealth.pojo.Admin;
import com.wealth.server.adminServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminServerImpl implements adminServer {
    @Autowired
    private adminMapper adminMapper;

    @Override
    public List<Admin> selectUserName(String value) {
        return adminMapper.selectUserName(value);
    }
}
