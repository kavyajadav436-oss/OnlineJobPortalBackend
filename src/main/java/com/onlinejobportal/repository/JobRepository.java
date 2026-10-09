package com.onlinejobportal.repository;

import com.onlinejobportal.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}