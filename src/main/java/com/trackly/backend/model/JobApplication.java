package com.trackly.backend.model;

import com.trackly.backend.enums.ApplicationStatus;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "applications")
public class JobApplication {

    @Id
    private String id;

    private String company;

    private String role;

    private ApplicationStatus status;

    private String location;

    private LocalDate appliedOn;

    private String jobUrl;

    private String notes;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;
}
