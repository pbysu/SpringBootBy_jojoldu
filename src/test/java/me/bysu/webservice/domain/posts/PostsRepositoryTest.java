package me.bysu.webservice.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired //auto DI
    PostsRepository postsRepository;

    @After //when test end, We delete all repository data
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void  LoadPost (){

        // PostsRepository has CRUD function : save

        //given
        //set env
        postsRepository.save(Posts.builder()
                .title("test post")
                .content("test content")
                .author("bysu park")
                .build()
                );

        //when
        // set act
        List<Posts> postsList = postsRepository.findAll();


        //then
        // Do
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("test post"));
        assertThat(posts.getContent(), is("test content"));

    }

    @Test
    public void BaseTimeEntity_save(){
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("test post")
                .content("test content")
                .author("bysu park")
                .build()
        );

        //when
        List<Posts> postsList =  postsRepository.findAll();

        //then

        Posts posts  = postsList.get(0);
        assertTrue(posts.getCreateDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }
}
