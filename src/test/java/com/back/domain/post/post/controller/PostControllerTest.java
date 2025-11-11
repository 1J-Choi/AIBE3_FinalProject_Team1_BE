package com.back.domain.post.post.controller;

import com.back.domain.post.post.common.ReceiveMethod;
import com.back.domain.post.post.common.ReturnMethod;
import com.back.domain.post.post.dto.PostCreateReqBody;
import com.back.domain.post.post.dto.PostImageReqBody;
import com.back.domain.post.post.dto.PostOptionReqBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("게시글 등록 성공")
    void createPost_success() throws Exception {
        // given
        PostCreateReqBody reqBody = PostCreateReqBody.builder()
                .title("맥북 대여합니다.")
                .content("맥북프로 16인치 풀옵션입니다.")
                .receiveMethod(ReceiveMethod.DIRECT)
                .returnMethod(ReturnMethod.DIRECT)
                .returnAddress1("서울특별시 강남구 테헤란로 1")
                .returnAddress2("101호")
                .regionIds(List.of(1L))
                .categoryId(1L)
                .deposit(10000)
                .fee(3000)
                .options(List.of(
                        new PostOptionReqBody("마우스 포함", 5000, 0)
                ))
                .images(List.of(new PostImageReqBody(true)))
                .build();

        // when && then
        mockMvc.perform(post("/api/v1/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reqBody)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.resultCode").value("200-1"))
                .andExpect(jsonPath("$.msg").value("게시글이 등록되었습니다."));
    }


}