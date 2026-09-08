package com.trackly.backend.controller;


import com.trackly.backend.dto.JobApplicationRequest;
import com.trackly.backend.dto.JobApplicationResponse;
import com.trackly.backend.service.JobApplicationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {

    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    @PostMapping()
    public JobApplicationResponse createApplication(
            @Valid @RequestBody JobApplicationRequest request){
        return service.create(request);
    }
}
