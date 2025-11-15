package com.back.domain.chat.dto;

import java.time.LocalDateTime;

public record ChatRoomListDto(
        Long id,
        LocalDateTime createdAt,
        ChatPostDto post,
        OtherMemberDto otherMember,

        String lastMessage,
        LocalDateTime lastMessageTime,
        Long unreadCount
) {
}

