package com.team5.webapi.dao;

import com.team5.webapi.model.UserVO;

public interface UserDAO {
    public UserVO login(UserVO dto);
}