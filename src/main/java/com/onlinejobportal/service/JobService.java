package com.onlinejobportal.service;

import com.onlinejobportal.entity.Job;
import com.onlinejobportal.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // READ
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // CREATE
    public Job addJob(Job job) {
        return jobRepository.save(job);
    }

    // UPDATE
    public Job updateJob(Long id, Job job) {
        Job existingJob = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        existingJob.setTitle(job.getTitle());
        existingJob.setCompany(job.getCompany());
        existingJob.setLocation(job.getLocation());
        existingJob.setDescription(job.getDescription());

        return jobRepository.save(existingJob);
    }

    // DELETE
    public void deleteJob(Long id) {
        if (!jobRepository.existsById(id)) {
            throw new RuntimeException("Job not found");
        }

        jobRepository.deleteById(id);
    }
}