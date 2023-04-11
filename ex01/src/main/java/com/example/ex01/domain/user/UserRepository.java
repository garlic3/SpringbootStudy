package com.example.ex01.domain.user;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    // 이메일을 통해 기존 가입자 여부 확인 메소드
    Optional<Users> findByEmail(String email);
}
