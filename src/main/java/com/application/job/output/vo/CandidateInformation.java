package com.application.job.output.vo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "applicant")
public class CandidateInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int candidateId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String collegeName;
    private String passedOutYear;
    private String resumeUrl;
    private String coverLetterUrl;
    private String jobId;
}
