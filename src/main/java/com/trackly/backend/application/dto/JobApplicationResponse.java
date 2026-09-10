package com.trackly.backend.application.dto;

import com.trackly.backend.application.enums.ApplicationStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class JobApplicationResponse {

    private String id;

    private String company;

    private String role;

    private ApplicationStatus status;

    private String location;

    private LocalDate appliedOn;

    private String jobUrl;

    private String notes;

    private Instant createdAt;

    private Instant updatedAt;
}
