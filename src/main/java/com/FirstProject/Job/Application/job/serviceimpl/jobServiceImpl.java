package com.FirstProject.Job.Application.job.serviceimpl;

import com.FirstProject.Job.Application.job.Job;
import com.FirstProject.Job.Application.job.jobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class jobServiceImpl implements jobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextID= 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextID++);
        jobs.add(job);

    }

    @Override
    public Job getJobById(Long id) {
        for(Job job:jobs ){
            if(job.getId().equals(id)){
                return job;
            }
        }return  null;

    }
}
