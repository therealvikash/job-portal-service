package com.application.job.dao;

import com.application.job.output.vo.CandidateInformation;
import com.application.job.output.vo.Vacancies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSubmissionDAO extends JpaRepository<CandidateInformation, String> {
}
