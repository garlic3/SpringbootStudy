package com.example.ex01.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    // @RequestParam : 외부에서 API로 넘김 파라미터를 가져오는 어노테이션
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amout){
        return new HelloResponseDto(name, amout);
    }
}
