package com.trackly.backend.dto;

import com.trackly.backend.enums.ApplicationStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class JobApplicationRequest {

    @NotBlank
    private String company;

    @NotBlank
    private String role;

    @NotNull
    private LocalDate appliedOn;

    @NotNull
    private ApplicationStatus status;

    private String location;

    private String jobUrl;

    private String notes;
}
