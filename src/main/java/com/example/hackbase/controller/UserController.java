package com.example.hackbase.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    private Logger logger= LoggerFactory.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping("/login")
    public String  login(@RequestBody String content){
        JSONObject jsonObject=JSONObject.parseObject(content);
        String username=jsonObject.get("username").toString();
        String password=jsonObject.get("password").toString();

        logger.info(username+":"+password);
        if(username.equalsIgnoreCase("admin") && password.equals("123456")){
            return "ok";
        }
        return "not allow in";
    }
}
