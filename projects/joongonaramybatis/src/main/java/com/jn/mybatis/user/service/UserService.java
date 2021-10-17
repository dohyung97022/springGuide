package com.jn.mybatis.user.service;

import com.jn.mybatis.user.domain.UserVO;
import com.jn.mybatis.user.persistance.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserVO getUser(Integer seq) {
        return userDAO.search(seq);
    }
}
