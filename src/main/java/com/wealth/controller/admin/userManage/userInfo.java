package com.wealth.controller.admin.userManage;

import com.wealth.controller.responseMsg;
import com.wealth.pojo.User;
import com.wealth.server.userServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/userManage/userInfo")
public class userInfo {
    @Autowired
    private userServer userServer;

    @GetMapping("/userList")
    @ResponseBody
    public String userList(@RequestParam(value="startID") int startID, @RequestParam(value="number") int number) {
        // 查询用户表
        System.out.println("收到userList请求");
        responseMsg response;
        try {
            int userNumber = userServer.selectUserNumber();
            System.out.println("查询数据表元组数量为：" + userNumber);
            if (userNumber <= 0) {
                response = responseMsg.failure("数据库查询为空");
            } else {
                List<User> userList = userServer.selectUserAll(startID,number);
                System.out.println("查询结果：" + userList.toString());
                response = responseMsg.success();
                response.add("userList",userList);
                response.add("userNumber",userNumber);
            }
            return response.toString();
        }catch (Error err) {
            System.out.println("查询数据库的过程中捕捉到异常：" + err.toString());
            response = responseMsg.error("数据库查询失败");
            return response.toString();
        }
    }
}
