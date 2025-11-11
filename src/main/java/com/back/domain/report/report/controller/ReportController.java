package com.back.domain.report.report.controller;

import com.back.domain.report.report.dto.ReportReqBody;
import com.back.domain.report.report.dto.ReportResBody;
import com.back.domain.report.report.service.ReportService;
import com.back.global.security.SecurityUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reports")
public class ReportController {

    private final ReportService reportService;

    @PostMapping
    public ResponseEntity<ReportResBody> postReport(@Valid @RequestBody ReportReqBody reportReqBody,
                                                    @AuthenticationPrincipal SecurityUser securityUser) {
        ReportResBody response = reportService.postReport(reportReqBody, securityUser.getId());
        return ResponseEntity.ok(response);
    }
}
