package me.bysu.webservice.domain;


import me.bysu.webservice.domain.posts.Posts;
import me.bysu.webservice.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void post_loading(){
        //given  :
        postsRepository.save(Posts.builder()
                .title("test post")
                .content("main text")
                .build());
        //when :
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("test post"));
        assertThat(posts.getContent(), is("main text"));

    }

    /*
    given
        테스트 기반 환경을 구축하는 단계
        여기선
        @builder의 사용법도 같이 확인
    when
        테스트 하고자 하는 행위 선언
        여기선 Posts가 DB에 insert 되는것을 확인하기 위함
     then
        테스트 결과 검증
        실제로 DB에 insert 되었는지 확인하기 위해 조회후, 입력된 값 확인
     */

}
