package com.team5.webapi.dao;

import com.team5.webapi.model.UserVO;

import org.apache.ibatis.session.SqlSession;
import org.mockito.InjectMocks;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
    @InjectMocks
    SqlSession sqlSession;

    @Override
    public UserVO login(UserVO dto) {
        return sqlSession.selectOne("com.team5.wepapi.mapper.AccountMapper", dto);
    }
}