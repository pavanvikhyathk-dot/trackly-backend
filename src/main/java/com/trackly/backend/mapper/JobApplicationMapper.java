package com.trackly.backend.mapper;

import com.trackly.backend.dto.JobApplicationRequest;
import com.trackly.backend.dto.JobApplicationResponse;
import com.trackly.backend.model.JobApplication;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobApplicationMapper {
    JobApplication toEntity(JobApplicationRequest request);
    JobApplicationResponse toResponse(JobApplication application);
}