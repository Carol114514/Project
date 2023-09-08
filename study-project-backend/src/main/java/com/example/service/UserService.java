package com.example.service;

import com.example.entity.user.AccountInfo;

public interface UserService {
    boolean saveUserInfo(AccountInfo info);
    AccountInfo useInfo(int uid);
    boolean saveEmail(String email,int uid);
    boolean changePassword(String old,String _new,int uid);
}
