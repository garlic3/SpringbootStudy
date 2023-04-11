package com.example.ex01.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// DB Layer 접근자
// extends JpaRepository<Entity 클래스, PK타입>
// Entity 클래스와 기본 Entity Repository는 함께 위치해야 한다
public interface PostsRepository extends JpaRepository<Posts, Long> {


    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
