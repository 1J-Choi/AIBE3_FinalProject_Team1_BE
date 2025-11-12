package com.back.domain.reservation.reservation.dto;

import com.back.domain.reservation.reservation.common.ReservationStatus;

public record UpdateReservationStatusReqBody(
        ReservationStatus status,
        String cancelReason,
        String rejectReason,
        String receiveCarrier,
        String receiveTrackingNumber,
        String returnCarrier,
        String returnTrackingNumber
) {
}
