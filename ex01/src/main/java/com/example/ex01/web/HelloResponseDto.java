package com.example.ex01.web;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// getter 메소드 생성
@Getter
// 선언된 모든 final 필드가 포함된 생성자 생성
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;

}

