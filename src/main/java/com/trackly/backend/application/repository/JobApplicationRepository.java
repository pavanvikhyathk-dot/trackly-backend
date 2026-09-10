package com.trackly.backend.application.repository;

import com.trackly.backend.application.enums.ApplicationStatus;
import com.trackly.backend.application.model.JobApplication;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JobApplicationRepository extends MongoRepository<JobApplication, String> {

    List<JobApplication> findByStatus(ApplicationStatus status);
}
