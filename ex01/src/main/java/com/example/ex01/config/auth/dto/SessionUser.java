package com.example.ex01.config.auth.dto;

import com.example.ex01.domain.user.Users;
import lombok.Getter;

import java.io.Serializable;

// 인증된 사용자 정보
// 직렬화 기능을 가진 세션 Dto
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(Users user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();

    }
}
