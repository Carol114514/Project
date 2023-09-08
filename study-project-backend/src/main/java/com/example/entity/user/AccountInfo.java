package com.example.entity.user;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AccountInfo {
    int uid;
    @Length(min = 2 , max = 8)
    String username;
    String sex;
    @Length(max = 11)
    String phone;
    @Length(max = 11)
    String qq;
    @Length(max = 20)
    String wx;
    @Length(max = 50)
    String blog;
    @Length(max = 200)
    String desc;
}
