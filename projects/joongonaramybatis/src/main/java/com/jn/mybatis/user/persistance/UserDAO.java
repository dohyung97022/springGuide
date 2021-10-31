package com.jn.mybatis.user.persistance;

import com.jn.mybatis.user.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDAO {
    UserVO search(Integer seq);
}
