package me.bysu.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;


// JpaRepository <Posts, Long> : Entity class and PK type
// auto add @Repository
// It supply CRUD Create, Read, Update,Delete

public interface PostsRepository extends JpaRepository<Posts, Long>{
    @Query("SELECT p " + "FROM Posts p " + "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();
}
