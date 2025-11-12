package com.back.domain.report.report.common.validator;

import com.back.domain.post.post.repository.PostRepository;
import com.back.domain.report.report.common.ReportType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PostReportValidator implements ReportValidator {

    private final PostRepository postRepository;

    @Override
    public boolean validateTargetId(ReportType reportType, Long targetId) {
        return reportType == ReportType.POST && postRepository.existsById(targetId);
    }
}
