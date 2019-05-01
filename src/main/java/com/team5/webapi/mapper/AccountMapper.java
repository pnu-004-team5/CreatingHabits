package com.team5.webapi.mapper;


import com.team5.webapi.model.Account_info;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {
    @Select("SELECT * from userTable where id = #{id} and password = #{password}")
    public Account_info readAccount(String id, String password);
}