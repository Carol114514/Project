package com.example.service.impl;

import com.example.entity.auth.Account;
import com.example.entity.user.AccountInfo;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper mapper;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

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

    @Override
    public boolean saveEmail(String email, int uid) {
        Account account = mapper.findAccountByNameOrEmail(email);
        if (account == null){
            mapper.updateEmail(email,uid);
        } else return account.getId() == uid;
        return true;
    }

    @Override
    public boolean changePassword(String old, String _new, int uid) {
        Account account = mapper.findAccountById(uid);
        if (encoder.matches(old,account.getPassword())) {
            String encode = encoder.encode(_new);
            mapper.updatePassword(encode,uid);
            return true;
        } else {
            return false;
        }
    }
}
