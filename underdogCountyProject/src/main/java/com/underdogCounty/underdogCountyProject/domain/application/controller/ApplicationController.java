package com.underdogCounty.underdogCountyProject.domain.application.controller;

import com.underdogCounty.underdogCountyProject.domain.application.entity.Application;
import com.underdogCounty.underdogCountyProject.domain.application.request.ApplicationCreationRequest;
import com.underdogCounty.underdogCountyProject.domain.application.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/application")
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody ApplicationCreationRequest request){
        return ResponseEntity.ok(applicationService.createApplication(request));
    }

    @GetMapping
    public ResponseEntity readApplicationList(){
        return ResponseEntity.ok(applicationService.readApplicationList());
    }

    @GetMapping("/{applicationId}")
    public ResponseEntity<ApplicationCreationRequest> readApplication(@PathVariable Long applicationId){
        return ResponseEntity.ok(applicationService.readApplication(applicationId));
    }
}
