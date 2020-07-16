package com.wealth.controller;

import com.wealth.pojo.Admin;
import com.wealth.pojo.User;
import com.wealth.server.adminServer;
import com.wealth.server.userServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import java.util.List;

@Controller
@RequestMapping("/login")
public class Login {
    /*======================================注入相关类========================================*/
    @Autowired
    private userServer userServer;
    @Autowired
    private adminServer adminServer;

    @PostMapping("/verify")
    @ResponseBody
    public String verify(@RequestBody String request, HttpServletResponse res) {
        System.out.println("收到post登录验证请求！");
        requestMsg msg = new requestMsg(request);
        String username = msg.getString("username");
        String password = msg.getString("password");
        System.out.println("\t用户名：" + username + "\n\t密码：" + password);
        responseMsg response;

        // 查询用户表
        List<User> resultUser = userServer.selectUserName(username);
        List<Admin> resultAdmin;
        System.out.println("用户表查询结果：" + resultUser);
        if (resultUser.isEmpty()) {                                 // 在用户表中未查询到,查询管理员表
            resultAdmin = adminServer.selectUserName(username);
            System.out.println("管理员表查询结果：" + resultAdmin);
            if (resultAdmin.isEmpty()) {                            // 在管理员表中未查询到
                response = responseMsg.failure("账户不存在");
            }else {                                                 // 该用户为管理员
                response = responseMsg.success();
                response.add("type","admin");
                response.add("id",resultAdmin.get(0).getId());
            }
        } else {
            response = responseMsg.success();
            response.add("code","SUCCESS");
            response.add("type","user");
            response.add("id", resultUser.get(0).getId());
        }

        // 返回数据
        res.setHeader("authorization","authorization token");   //设置响应头
        return response.toString();
    }
}
