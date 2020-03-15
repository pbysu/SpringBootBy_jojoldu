package me.bysu.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;



// JpaRepository <Posts, Long> : Entity class and PK type
// auto add @Repository
// It supply CRUD Create, Read, Update,Delete
public interface PostsRepository extends JpaRepository<Posts, Long>{
}
