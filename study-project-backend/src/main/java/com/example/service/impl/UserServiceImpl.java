package com.example.service.impl;

import com.example.entity.auth.Account;
import com.example.entity.user.AccountInfo;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper mapper;

    @Override
    public boolean saveUserInfo(AccountInfo info) {
        Account account = mapper.findAccountByNameOrEmail(info.getUsername());
        if (account == null){
            mapper.updateUsername(info.getUsername(),info.getUid());
        } else if(account.getId() != info.getUid()){
            return false;
        }
        mapper.saveInfo(info);
        return true;
    }

    @Override
    public AccountInfo useInfo(int uid) {
        return mapper.findIndoById(uid);
    }
}
