package com.trackly.backend.service;

import com.trackly.backend.dto.JobApplicationRequest;
import com.trackly.backend.dto.JobApplicationResponse;
import com.trackly.backend.mapper.JobApplicationMapper;
import com.trackly.backend.model.JobApplication;
import com.trackly.backend.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

@Service
public class JobApplicationService {

    private final JobApplicationRepository repository;

    private final JobApplicationMapper mapper;

    public JobApplicationService(JobApplicationRepository repository, JobApplicationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }



    public JobApplicationResponse create(JobApplicationRequest request)
    {
        JobApplication application = mapper.toEntity(request);
        JobApplication saved = repository.save(application);

        return mapper.toResponse(saved);
    }
}
