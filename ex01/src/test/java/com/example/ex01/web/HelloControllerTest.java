package com.example.ex01.web;

import com.example.ex01.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// 스프링 부트 테스트와 Junit 연결
@RunWith(SpringRunner.class)
// 컨트롤러 테스트를 위해 사용
// @WebMvcTest 어노테이션은 WebSecurityConfiguerAdpater, WebMvcConfigurer, @ControllerAdvice, @Controller를 읽는다
// @Repository, @Service, @Component 는 스캔 대상이 아니어서 스캔대상에 추가한다
@WebMvcTest(controllers = HelloController.class, excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)})
public class HelloControllerTest {
    // 스프링 빈 주입
    @Autowired
    // 웹 API 테스트 사용
    // 스프링 MVC 테스트의 시작점
    private MockMvc mvc;

    @WithMockUser(roles = "USER")
    @Test
    public void helloTest() throws Exception {
        String hello = "hello";
        // perform() : MockMVC를 통해 /hello 주소로 HTTP GET 요청을 보낸다
        // status().isOk() : HTTP Header의 status 검증(200일 경우 true)
        // content().string() : 응답 본문의 내용을 특정문자열과 비교하여 검증
        mvc.perform(get("/hello")).andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @WithMockUser(roles = "USER")
    @Test
    public void helloDtoTest() throws Exception {
        String name = "hello";
        int amount = 1000;

        // param() : 요청 파라미터 설정(String만 허용)
        // jsonPath() : JSON 응답값을 필드별로 검증할수 있는 메소드, $를 기준으로 필드명 명시
        mvc.perform(get("/hello/dto").param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));


    }



}
