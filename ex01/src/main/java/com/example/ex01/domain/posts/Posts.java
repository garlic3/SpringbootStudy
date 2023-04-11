package com.example.ex01.domain.posts;

import com.example.ex01.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본 생성자 추가
@Getter // Getter 메소드 추가
@Entity // 테이블과 연결될 클래스
public class Posts extends BaseTimeEntity {

    @Id // 기본키 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 사용
    private Long id;

    @Column(length = 500, nullable = false) // 컬럼 사이즈 500, null 허용 X
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // 컬럼 타입 TEXT, null 허용 X
    private String content;

    private String author;
    @Builder // 빌더 패턴 클래스 생성, 생성자에 선언시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
