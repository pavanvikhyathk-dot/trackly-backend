package com.trackly.backend.application.mapper;

import com.trackly.backend.application.dto.JobApplicationRequest;
import com.trackly.backend.application.dto.JobApplicationResponse;
import com.trackly.backend.application.model.JobApplication;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface JobApplicationMapper {
    JobApplication toEntity(JobApplicationRequest request);
    JobApplicationResponse toResponse(JobApplication application);
    void updateEntityFromRequest(JobApplicationRequest request, @MappingTarget JobApplication application);
}