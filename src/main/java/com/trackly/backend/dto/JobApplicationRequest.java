package com.trackly.backend.dto;

import com.trackly.backend.enums.ApplicationStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class JobApplicationRequest {

    private String company;

    private String role;

    private ApplicationStatus status;

    private String location;

    private LocalDate appliedOn;

    private String jobUrl;

    private String notes;
}
