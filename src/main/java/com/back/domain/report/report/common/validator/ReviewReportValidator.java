package com.back.domain.report.report.common.validator;

import com.back.domain.report.report.common.ReportType;
import com.back.domain.review.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReviewReportValidator implements ReportValidator {

    private final ReviewRepository reviewRepository;

    @Override
    public boolean validateTargetId(ReportType reportType, Long targetId) {
        return reportType == ReportType.REVIEW && reviewRepository.existsById(targetId);
    }
}
