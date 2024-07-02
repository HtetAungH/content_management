package com.content_management.system.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

public class PostModel {
    @Getter 
    @Setter
    private Long id;
    @Getter 
    @Setter
    private String title;
    @Getter 
    @Setter
    private String content;
    @Getter 
    @Setter
    private String author;
    @Getter 
    @Setter
    private LocalDateTime createdAt;
}
