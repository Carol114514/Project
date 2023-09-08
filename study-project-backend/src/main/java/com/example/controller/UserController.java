package com.example.controller;

import com.example.entity.RestBean;
import com.example.entity.user.AccountInfo;
import com.example.entity.user.AccountUser;
import com.example.service.UserService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$";



    @Resource
    UserService service;

    @GetMapping("/me")
    public RestBean<AccountUser> me(@SessionAttribute("account") AccountUser user){
        return RestBean.success(user);
    }

    @PostMapping("/save-info")
    public RestBean<String> saveInfo(@RequestBody @Validated AccountInfo info,
                                     @SessionAttribute("account") AccountUser user){
        info.setUid(user.getId());
        if(service.saveUserInfo(info)){
            user.setUsername(info.getUsername());
            return RestBean.success();
        } else {
            return RestBean.failure(400,"用户名已存在");
        }
    }

    @GetMapping("/info")
    public RestBean<AccountInfo> info(@SessionAttribute("account") AccountUser user){
        return RestBean.success(service.useInfo(user.getId()));
    }

    @PostMapping("/save-email")
    public RestBean<String> saveEmail(@Pattern (regexp = EMAIL_REGEX) @RequestParam("email") String email,
                               @SessionAttribute("account") AccountUser user){
        if(service.saveEmail(email, user.getId())){
            user.setEmail(email);
            return RestBean.success();
        } else {
            return RestBean.failure(400,"该邮件已存在");
        }
    }

    @GetMapping("/email")
    public RestBean<String> email(@SessionAttribute("account") AccountUser user){
        return RestBean.success(user.getEmail());
    }

    @PostMapping("/save-password")
    public RestBean<String> savePassword(@Length(min = 6, max = 16) @RequestParam("old") String pass_old,
                                         @Length(min = 6, max = 16) @RequestParam("new") String pass_new,
                                         @SessionAttribute("account") AccountUser user){
        if (service.changePassword(pass_old,pass_new,user.getId())) {
            return RestBean.success();
        } else {
            return RestBean.failure(400,"原密码错误");
        }
    }
}
