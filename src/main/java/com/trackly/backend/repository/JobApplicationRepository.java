package com.trackly.backend.repository;

import com.trackly.backend.enums.ApplicationStatus;
import com.trackly.backend.model.JobApplication;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JobApplicationRepository extends MongoRepository<JobApplication, String> {

    List<JobApplication> findByStatus(ApplicationStatus status);
}
