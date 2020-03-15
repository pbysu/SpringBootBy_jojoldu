package me.bysu.webservice.web;

import lombok.AllArgsConstructor;
import me.bysu.webservice.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
// auto fix (prefix: src/main/resources/templates, suffix: .hbs)
// because use handlebars
public class WebController {

    private PostsService postsService;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("posts",postsService.findAllDesc());
        return "main";
    }
}
