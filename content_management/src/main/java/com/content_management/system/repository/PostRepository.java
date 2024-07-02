package com.content_management.system.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.content_management.system.model.PostModel;

@Mapper
public interface PostRepository {
    void createPost(PostModel postModel);
    List<PostModel> getAllPosts();
    PostModel getPostById(Long id);
}
