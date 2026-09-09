package com.trackly.backend.service;

import com.trackly.backend.dto.JobApplicationRequest;
import com.trackly.backend.dto.JobApplicationResponse;
import com.trackly.backend.enums.ApplicationStatus;
import com.trackly.backend.mapper.JobApplicationMapper;
import com.trackly.backend.model.JobApplication;
import com.trackly.backend.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<JobApplicationResponse> getAll()
    {
        return repository.findAll().
                stream().
                map(mapper :: toResponse)
                .toList();
    }

    public List<JobApplicationResponse> getByStatus(ApplicationStatus status)
    {
        return repository.findByStatus(status).
                stream().
                map(mapper :: toResponse)
                .toList();
    }

    public JobApplicationResponse update(String id, JobApplicationRequest request)
    {
        JobApplication application = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found: " + id));
        mapper.updateEntityFromRequest(request, application);
        JobApplication saved = repository.save(application);
        return mapper.toResponse(saved);
    }

    public void deleteById(String id)
    {
        repository.deleteById(id);
    }
}
