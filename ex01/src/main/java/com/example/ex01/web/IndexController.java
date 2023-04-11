package com.example.ex01.web;

import com.example.ex01.service.posts.PostsService;
import com.example.ex01.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    // 경로: src/main/resources/templates
    // 확장자: .mustache
    // View Resolver가 처리한다
    @GetMapping("/")
    public String index(Model model){
        // Model : 서버 템플릿 엔진에서 사용할수 있는 객체 저장
        model.addAttribute("posts", postsService.findAllByDesc());
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
