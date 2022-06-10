package com.example.tools.controller;

import com.example.tools.pojo.User;
import com.example.tools.service.UserService;

import com.example.tools.utils.Result;
import com.example.tools.vo.voUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    private Result<User> userResult = new Result<User>();
    @RequestMapping("/user/signin")
    public Result<User> SignIn(@RequestBody voUser vouser) {

        System.out.println("vouser: "+ vouser.toString());
        User user = userService.SelectUser(vouser.getUname());

        if(user==null){
            userResult.setData(null);
            userResult.code = 400;
            userResult.setMsg("用户不存在");
        }else{
            if(user.getPasswd().equals(vouser.getPasswd())){//密码是字符不能直接等于

                userResult.setData(user);
                userResult.code = 200;
                userResult.setMsg("登陆成功");
            }else{
                userResult.setData(null);
                userResult.code = 300;
                userResult.setMsg("密码错误");
            }
        }
        System.out.println("------------------请求路径："+"/user/signin");
        System.out.println(userResult.toString());
        return userResult;
    }

    @RequestMapping("/user/signup")
    public Result<User> SignUp(@RequestBody User user) {
        System.out.println(user);
        if(userService.SelectUser(user.getUname())==null){
            int res = userService.InsertUser(user);
            if(res==1){
                userResult.setCode(200);
                userResult.setMsg("注册成功");
                userResult.setData(user);
            }
        }else{
            userResult.setCode(400);
            userResult.setMsg("用户名已存在");
        }
        System.out.println("------------------请求路径："+"/user/signup");
        System.out.println(userResult.toString());
        return userResult;
    }

    @RequestMapping("/user/modify")
    public Result<User> Modify(@RequestBody User user) {
        int res = userService.UpdateUser(user);
        if(res==1){
            user = userService.SelectUser(user.getUname());
            userResult.setCode(200);
            userResult.setMsg("修改成功");
            userResult.setData(user);
        }else{
            userResult.setCode(400);
            userResult.setMsg("修改失败");
            userResult.setData(null);
        }
        System.out.println("------------------请求路径："+"/user/modify");
        System.out.println(userResult.toString());
        return userResult;
    }
}
