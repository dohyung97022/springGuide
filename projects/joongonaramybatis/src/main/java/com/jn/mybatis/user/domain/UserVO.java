package com.jn.mybatis.user.domain;

import com.jn.mybatis.user.common.UserStatus;
import com.jn.mybatis.user.common.UserType;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserVO {

    private final Long userSeq;
    private final Long storeSeq;
    private final String userId;
    private final String userName;
    private final String userPassword;
    private final UserType userType;
    private final UserStatus userStatus;
    private final LocalDateTime userLastLoginDate;
    private final LocalDateTime userLastLogoutDate;
    private final LocalDateTime userUpdateDate;

    @Builder
    public UserVO(Long userSeq, Long storeSeq, String userId, String userName, String userPassword, UserType userType,
        UserStatus userStatus, LocalDateTime userLastLoginDate, LocalDateTime userLastLogoutDate, LocalDateTime userUpdateDate) {
        this.userSeq = userSeq;
        this.storeSeq = storeSeq;
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
        this.userStatus = userStatus;
        this.userLastLoginDate = userLastLoginDate;
        this.userLastLogoutDate = userLastLogoutDate;
        this.userUpdateDate = userUpdateDate;
    }
}
