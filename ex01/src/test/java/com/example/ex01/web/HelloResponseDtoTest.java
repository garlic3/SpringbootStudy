package com.example.ex01.web;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

// getter 메소드 생성

// 선언된 모든 final 필드가 포함된 생성자 생성

public class HelloResponseDtoTest {

    @Test
    public void lombokTest(){
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // asserThat() : 검증 라이브러리의 검증 메소드
        // isEqualTo() : 동등 비교 메소드
        assertThat(dto.getName()).isEqualTo(name);

        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}

