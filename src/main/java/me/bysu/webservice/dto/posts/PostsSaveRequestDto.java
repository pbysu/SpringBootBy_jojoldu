package me.bysu.webservice.dto.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.bysu.webservice.domain.posts.Posts;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    //Entity 클래스를 Request/ Response 클래스로 사용해서는 안됩니다.
    //Entity 클래스와 Controller에서 쓸 DTO는 분리
    //Entity class do not change often

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
        }
}
