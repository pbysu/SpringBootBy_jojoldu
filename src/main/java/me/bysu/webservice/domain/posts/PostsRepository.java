package me.bysu.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//jpaRepository has @Repository
public interface PostsRepository extends JpaRepository<Posts, Long>{
}
