package com.content_management.system.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.content_management.system.model.PostModel;
import com.content_management.system.repository.PostRepository;
import com.content_management.system.service.PostService;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public void createPost(PostModel postModel) {
        postModel.setCreatedAt(LocalDateTime.now());
        postRepository.createPost(postModel);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return postRepository.getAllPosts();
    }

    @Override
    public PostModel getPostById(Long id) {
        return postRepository.getPostById(id);
    }
}
