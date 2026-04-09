package com.blog.post.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.post.entity.PostEntity;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    List<PostEntity> findByUserId(Long userId);
}