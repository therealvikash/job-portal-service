package com.application.job.controller;

import com.application.job.output.vo.CandidateInformation;
import com.application.job.output.vo.Vacancies;
import com.application.job.service.JobApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/job-portal")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @GetMapping("/list-all-jobs")
    public ResponseEntity<List<Vacancies>> getAllJobs() {
        List<Vacancies> jobs = jobApplicationService.getAllJobs();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @PostMapping(value = "/apply", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> applyJob(
            @RequestPart("candidateInfo") CandidateInformation candidateInformation,
            @RequestPart(value = "resume", required = false) MultipartFile resume,
            @RequestPart(value = "coverLetter", required = false) MultipartFile coverLetter) {
        String jobs = jobApplicationService.applyJob(candidateInformation, resume, coverLetter);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }
}