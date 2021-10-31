package com.jn.mybatis.user.common;

import lombok.Getter;

@Getter
public enum UserStatus {

    ACTIVE(0, "정상회원"),
    SLEEP(1, "동면회원"),
    BANNED(2, "강퇴회원"),
    DELETED(3, "삭제회원");

    private Integer UserStatus;
    private String UserStatusText;

    UserStatus(int userStatus, String userStatusText) {
        UserStatus = userStatus;
        UserStatusText = userStatusText;
    }
}
