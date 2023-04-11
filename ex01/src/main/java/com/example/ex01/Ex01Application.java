package com.example.ex01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication // 프로젝트 메인 클래스. 프로젝트 최상단에 위치
public class Ex01Application {

    // 내장 WAS 실행
    public static void main(String[] args) {
        SpringApplication.run(Ex01Application.class, args);
    }

}
