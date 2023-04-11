package com.example.ex01.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // 단위 테스트 종료될때 마다 실행할 메소드 -> 배포전 테스트간 데이터 침범을 막기 위해 주로 사용
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void read() {
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // insert/update 쿼리 실행
        postsRepository.save(Posts.builder().title(title).content(content).author("min@min.com").build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }


    @Test
    public void addBaseTimeEntityTest(){
        // given
        LocalDateTime now = LocalDateTime.of(2023, 4, 11, 15, 56);
        postsRepository.save(Posts.builder().title("title").content("content").author("author").build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);

        System.out.println("=======================");
        System.out.println("created Date : " + posts.getCreatedDate());
        System.out.println("modified Date : " + posts.getModifiedDate());
        System.out.println("=======================");

        // 검증
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }

}
