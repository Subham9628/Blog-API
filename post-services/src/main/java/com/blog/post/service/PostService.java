package com.blog.post.service;

import java.util.List;

import com.blog.post.dto.PostDto;

public interface PostService {

    PostDto createPost(PostDto dto);

    List<PostDto> getAllPosts();

    PostDto getPostById(Long id);

    List<PostDto> getPostsByUser(Long userId);

    PostDto updatePost(Long id, PostDto dto);

    void deletePost(Long id);
}