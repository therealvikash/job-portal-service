package com.application.job.output.vo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_table")
public class Vacancies {
    @Id
    private String jobId;
    private String jobDesignation;
    @OneToMany(mappedBy = "vacancies",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<JobDescription> jobDescriptions;
    private String expRange;
    @OneToMany(mappedBy = "vacancies",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<JobResponsibility> jobResponsibilities;
    @OneToMany(mappedBy = "vacancies",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<RequiredQualification> requiredQualifications;
    @OneToMany(mappedBy = "vacancies",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<DesiredQualification> desiredQualifications;
}