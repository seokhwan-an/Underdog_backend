package com.underdogCounty.underdogCountyProject.domain.application.controller;

import com.underdogCounty.underdogCountyProject.domain.application.dto.ApplicationRequestDto;
import com.underdogCounty.underdogCountyProject.domain.application.dto.ApplicationResponseDto;
import com.underdogCounty.underdogCountyProject.domain.application.entity.Application;
import com.underdogCounty.underdogCountyProject.domain.application.service.ApplicationService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${app-application}")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<Application> createApplication(@Valid @RequestBody ApplicationRequestDto applicationRequestDto) {
        return ResponseEntity.ok(applicationService.createApplication(applicationRequestDto));
    }

    @GetMapping
    public ResponseEntity readApplications(@RequestParam(required = false) String name) {
        return ResponseEntity.ok(applicationService.readApplications(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationResponseDto> readApplication(@PathVariable Long id) {
        return ResponseEntity.ok(applicationService.readApplication(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Application> updateApplication(@PathVariable Long id,
        @RequestBody ApplicationRequestDto applicationRequestDto) {
        return ResponseEntity.ok(applicationService.updateApplication(id, applicationRequestDto));
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id){
        applicationService.deleteApplication(id);
    }
}
