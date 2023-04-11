package com.example.ex01.web;

import com.example.ex01.config.auth.LoginUser;
import com.example.ex01.config.auth.dto.SessionUser;
import com.example.ex01.service.posts.PostsService;
import com.example.ex01.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
    // 경로: src/main/resources/templates
    // 확장자: .mustache
    // View Resolver가 처리한다
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        // Model : 서버 템플릿 엔진에서 사용할수 있는 객체 저장
        model.addAttribute("posts", postsService.findAllByDesc());

        // 로그인 성공시
        if(user != null){
            // 세션에 SessionUser 저장
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }



}
