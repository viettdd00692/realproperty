package com.example.realproperty.dao;

import com.example.realproperty.entity.UserAccount;

public interface UserDao {
    UserAccount getUserByUsername(String username);
}
