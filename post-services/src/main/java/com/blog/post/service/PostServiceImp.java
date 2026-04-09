package com.blog.post.service;




import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.post.dto.PostDto;
import com.blog.post.entity.PostEntity;
import com.blog.post.repository.PostRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImp implements PostService {

	@Autowired
	private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto dto) {
        PostEntity post = new PostEntity();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setImageName(dto.getImageName());
        post.setUserId(dto.getUserId());
        post.setCreatedDate(new Date());

        PostEntity saved = postRepository.save(post);
        return mapToDto(saved);
    }

    @Override
    public List<PostDto> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(Long id) {
        PostEntity post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        return mapToDto(post);
    }

    @Override
    public List<PostDto> getPostsByUser(Long userId) {
        return postRepository.findByUserId(userId)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto updatePost(Long id, PostDto dto) {
        PostEntity post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setImageName(dto.getImageName());

        PostEntity updated = postRepository.save(post);
        return mapToDto(updated);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    private PostDto mapToDto(PostEntity post) 
    {
        return new PostDto(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getImageName(),
                post.getUserId()
        );
    }
}