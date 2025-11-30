package com.application.job.output.vo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "desired_qualification")
public class DesiredQualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long desiredQualificationId;
    private String desiredQualification;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    @JsonBackReference
    private Vacancies vacancies;
}
