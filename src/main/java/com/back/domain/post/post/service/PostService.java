package com.back.domain.post.post.service;

import com.back.domain.post.post.dto.PostCreateReqBody;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    public void create(@Valid PostCreateReqBody reqBody) {
    }
}
