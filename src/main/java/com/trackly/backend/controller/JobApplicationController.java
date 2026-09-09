package com.trackly.backend.controller;


import com.trackly.backend.dto.JobApplicationRequest;
import com.trackly.backend.dto.JobApplicationResponse;
import com.trackly.backend.enums.ApplicationStatus;
import com.trackly.backend.service.JobApplicationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {

    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    @GetMapping
    public List<JobApplicationResponse> getApplications()
    {
        return service.getAll();
    }

    @GetMapping(params = "status")
    public List<JobApplicationResponse> getApplicationsByStatus(@RequestParam ApplicationStatus status)
    {
        return service.getByStatus(status);
    }

    @PostMapping("/create")
    public JobApplicationResponse createApplication(
            @Valid @RequestBody JobApplicationRequest request){
        return service.create(request);
    }

    @PutMapping("/{id}")
    public JobApplicationResponse update(@PathVariable String id, @Valid @RequestBody JobApplicationRequest request)
    {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id)
    {
        service.deleteById(id);
    }
}
