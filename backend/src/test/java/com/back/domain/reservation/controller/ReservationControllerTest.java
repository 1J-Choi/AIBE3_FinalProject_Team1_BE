package com.back.domain.reservation.controller;

import com.back.BaseContainerIntegrationTest;
import com.back.domain.reservation.repository.ReservationRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

@Sql("/sql/reservations.sql")
class ReservationControllerTest extends BaseContainerIntegrationTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    @DisplayName("작동 테스트")
    void test() {

    }
}