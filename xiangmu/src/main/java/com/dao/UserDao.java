package com.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.pojo.User;
@Mapper
@Component
public interface UserDao {
    String	checkName(User user);
    String	checkUser(User user);
    Integer	saveUser(User user);
    
}
