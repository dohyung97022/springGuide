package com.jn.mybatis.user.controller;

import com.jn.mybatis.user.domain.UserVO;
import com.jn.mybatis.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 단일 회원 가져오기
     */
    @GetMapping("/{seq}")
    public UserVO getUser(@PathVariable Integer seq) {
        System.out.println("test");
        System.out.println(seq);
        return userService.getUser(seq);
    }
}
