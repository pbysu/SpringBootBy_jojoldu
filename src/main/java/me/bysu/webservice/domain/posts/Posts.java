package me.bysu.webservice.domain.posts;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
public class Posts {

    @Id
    @GeneratedValue
    private Long id;


}
