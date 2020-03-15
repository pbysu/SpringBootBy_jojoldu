package me.bysu.webservice.Service;

import me.bysu.webservice.domain.posts.Posts;
import me.bysu.webservice.domain.posts.PostsRepository;
import me.bysu.webservice.dto.posts.PostsSaveRequestDto;
import me.bysu.webservice.service.PostsService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    public PostsServiceTest() {
    }

    @After
    public void cleanup () {
        postsRepository.deleteAll();
    }

    @Test
    public void DtoData_savePostsTable () {

        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("bysu park")
                .content("test")
                .title("test title")
                .build();

        //when
        postsService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
    }
}