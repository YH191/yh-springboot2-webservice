package com.yh.book.springboot.web.domain.posts;

import com.yh.book.springboot.domain.posts.Posts;
import com.yh.book.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void contentsave_getcontent(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .writer("ppyh09@naver.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

//    @Test
//    public void BaseTimeEntity_add(){
//        //given
//        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
//        postsRepository.save(Posts.builder()
//                .title("title")
//                .content("content")
//                .writer("writer")
//                .build());
//        //when
//        List<Posts> postsList = postsRepository.findAll();
//
//        //then
//        Posts posts = postsList.get(0);
//
//        System.out.println(">>>>>> createDate="+posts.getCreatedDate()+", modifiedDate="
//                            +posts.getModifiedDate());
//            assertThat(posts.getCreatedDate()).isAfter(now);
//            assertThat(posts.getModifiedDate()).isAfter(now);
//    }

}
