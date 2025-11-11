package com.back.domain.post.post.dto;

import lombok.Builder;

@Builder
public record PostOptionResBody(
        String name,
        Integer deposit,
        Integer fee
) {}
