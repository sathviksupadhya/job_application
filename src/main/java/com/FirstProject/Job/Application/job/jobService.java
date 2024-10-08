package com.FirstProject.Job.Application.job;

import java.util.List;

public interface jobService {
    List<Job> findAll();
    void createJob(Job job);

    Job getJobById(Long id);

    Boolean deleteJobById(Long id);

    boolean updateJobById(Long id, Job updatedJob);
}
