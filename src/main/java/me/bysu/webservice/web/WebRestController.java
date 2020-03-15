package me.bysu.webservice.web;

import lombok.AllArgsConstructor;
import me.bysu.webservice.domain.posts.PostsRepository;
import me.bysu.webservice.dto.posts.PostsSaveRequestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;

    // just pring hello~
    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot World";
    }

    //we do not use Autowired
    // we still DI, using @AllArgsConstructor
    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }

}
