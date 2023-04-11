package com.example.ex01.config.auth;

import com.example.ex01.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable() // h2-console 화면을 사용하기 위한 옵션 disable
                // authorizeRequests:  URL별 권한 관리 설정 옵션 시작점. antMatchers 옵션 사용 가능
                .and().authorizeRequests().antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**")
                // antMatchers : 권한 관리 대상 지정 옵션. URL, HTTP 메소드별 관리 가능
                // "/" -> permitAll() 전체 열람 권한 "/api/vi/**" USER 권한 가진 사람만 가능하도록 부여
                .permitAll().antMatchers("/api/v1/**").hasRole(Role.USER.name())
                // anyRequest :  설정된 값 외의 나머지 URL
                // authenticated : 인증된 사용자들에게만 허용(로그인한 사용자)
                .anyRequest().authenticated()
                // 로그아웃 기능에 대한 설정 진입점. 로그아웃 성공시 "/" 주소로 이동
                .and().logout().logoutSuccessUrl("/")
                // oauth2Login : OAuth2 로그인 기능에 대한 설정 진입점
                // userInfoEndpoint : 로그인 성공 이후 삿용자 정보를 가져올때의 설정
                // userService : 소셜 로그인 성공시 후속 조치를 진행할 인터페이스의 구현체 등록
                // 리소스 서버에서 사용자 정보를 가져온 상태에서 추가 진행할 기능 명시
                .and().oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
    }
}
