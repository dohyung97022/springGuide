package com.jn.mybatis.user.common;

import lombok.Getter;

@Getter
public enum UserType {

    NORMAL(0,"일반회원"),
    SPONSOR(1, "협찬회원"),
    ADMIN(3, "관리자회원");

    private Integer userType;
    private String userTypeName;

    UserType(Integer userType, String userTypeName) {
        this.userType = userType;
        this.userTypeName = userTypeName;
    }
}
