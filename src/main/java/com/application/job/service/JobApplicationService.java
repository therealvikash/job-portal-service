package com.application.job.service;

import com.application.job.dao.JobApplicationDAO;
import com.application.job.dao.JobSubmissionDAO;
import com.application.job.output.vo.CandidateInformation;
import com.application.job.output.vo.Vacancies;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class JobApplicationService {

    private final JobApplicationDAO jobApplicationDAO;
    private final JobSubmissionDAO jobSubmissionDAO;
    private final S3Service s3Service;
    public JobApplicationService(JobApplicationDAO jobApplicationDAO, JobSubmissionDAO jobSubmissionDAO, S3Service s3Service) {
        this.jobApplicationDAO = jobApplicationDAO;
        this.jobSubmissionDAO = jobSubmissionDAO;
        this.s3Service = s3Service;
    }

    public List<Vacancies> getAllJobs() {
        return jobApplicationDAO.findAll();
    }

    public String applyJob(CandidateInformation candidateInfo, MultipartFile resume, MultipartFile coverLetter) {
        try {
            String resumeUrl = resume != null ? s3Service.uploadFile(resume, candidateInfo.getCandidateId(), "resume") : null;
            String coverLetterUrl = coverLetter != null ? s3Service.uploadFile(coverLetter, candidateInfo.getCandidateId(), "coverletter") : null;

            // You can now save resumeUrl and coverLetterUrl into the DB
            candidateInfo.setResumeUrl(resumeUrl);
            candidateInfo.setCoverLetterUrl(coverLetterUrl);

            // Save to DB or forward to downstream system
            jobSubmissionDAO.save(candidateInfo);
            return "Job Application Submitted Successfully!";
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload files", e);
        }
    }
}
