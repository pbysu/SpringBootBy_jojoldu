package me.bysu.webservice.domain.posts;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access= AccessLevel.PROTECTED) // default Construct, access :  restrict protected
@Getter
@Entity // Entity : It will link Table
public class Posts {

    @Id // PK field (Primary Key,
    @GeneratedValue
    private Long id;

    @Column(length=500, nullable = false) //Colum , length defalt size is 255
    private String title;

    @Column(columnDefinition = "TEXT", nullable =false) //change Type : default varchar-> txt
    private String content;

    private String author;

    @Builder // create Builder pattern class
    public Posts(String title, String content, String author){
        this.title = title;
        this.content= content;
        this.author = author;
    }
}
