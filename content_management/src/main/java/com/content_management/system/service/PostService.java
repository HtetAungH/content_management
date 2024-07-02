package com.content_management.system.service;

import java.util.List;
import com.content_management.system.model.PostModel;

public interface PostService {
    void createPost(PostModel postModel);
    List<PostModel> getAllPosts();
    PostModel getPostById(Long id);
}
