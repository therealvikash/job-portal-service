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
@Table(name = "job-responsibility")
public class JobResponsibility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobRespId;
    private String jobResp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    @JsonBackReference
    private Vacancies vacancies;
}
