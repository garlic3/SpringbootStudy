package com.example.ex01.service.posts;

import com.example.ex01.domain.posts.Posts;
import com.example.ex01.domain.posts.PostsRepository;
import com.example.ex01.web.dto.PostListResponseDto;
import com.example.ex01.web.dto.PostsResponseDto;
import com.example.ex01.web.dto.PostsSaveRequestDto;
import com.example.ex01.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    // 추가
    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();

    }

    // 수정
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        // 존재하지 않을 경우 IllegalArgumentException 예외 발생
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시물이 없습니다. id = " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    // 조회
    public PostsResponseDto findById(Long id) {
        // 존재하지 않을 경우 IllegalArgumentException 예외 발생
        Posts entity = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true) // 트랙잭션의 범위를 유지하면서 조회 기능만 가능 -> 조회속도 개선
    public List<PostListResponseDto> findAllByDesc(){
        return postsRepository.findAllDesc().stream().map(PostListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        // 엔티티 조회후 삭제
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다" + id));
        postsRepository.delete(posts);
    }

}
