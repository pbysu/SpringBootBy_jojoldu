package me.bysu.webservice.web;

import lombok.AllArgsConstructor;
import me.bysu.webservice.dto.posts.PostsSaveRequestDto;
import me.bysu.webservice.service.PostsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class WebRestController {


    private PostsService postsService;
    // just pring hello~
    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot World";
    }

    //we do not use Autowired
    // we still DI, using @AllArgsConstructor
    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }

}
