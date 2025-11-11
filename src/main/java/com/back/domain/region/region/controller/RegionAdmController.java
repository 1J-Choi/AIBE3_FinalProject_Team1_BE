package com.back.domain.region.region.controller;

import com.back.domain.region.region.dto.RegionCreateReqBody;
import com.back.domain.region.region.dto.RegionResBody;
import com.back.domain.region.region.service.RegionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/adm/regions")
public class RegionAdmController {

    private final RegionService regionService;

    @PostMapping
    public ResponseEntity<RegionResBody> createRegion(@Valid @RequestBody RegionCreateReqBody regionCreateReqBody) {
        RegionResBody regionResBody = regionService.createRegion(regionCreateReqBody);
        return ResponseEntity.ok(regionResBody);
    }
}
