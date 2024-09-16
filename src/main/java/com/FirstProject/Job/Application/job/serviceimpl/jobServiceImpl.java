package com.FirstProject.Job.Application.job.serviceimpl;

import com.FirstProject.Job.Application.job.Job;
import com.FirstProject.Job.Application.job.jobRepository;
import com.FirstProject.Job.Application.job.jobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service

public class jobServiceImpl implements jobService {

    private jobRepository jobrepo;
    public jobServiceImpl(jobRepository jobrepo) {
        this.jobrepo = jobrepo;
    }

    // private List<Job> jobs = new ArrayList<>();
    private Long nextID= 1L;

    @Override
    public List<Job> findAll() {
        return jobrepo.findAll();
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextID++);
        jobrepo.save(job);

    }

    @Override
    public Job getJobById(Long id) {
        return jobrepo.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteJobById(Long id) {
        try {
            jobrepo.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        Optional<Job> optionalJob = jobrepo.findById(id);
        if(optionalJob.isPresent()){
            Job job = optionalJob.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setMaxSalary(updatedJob.getMinSalary());
            job.setLocation(updatedJob.getLocation());
            jobrepo.save(job);
            return true;
            }
        return false;
    }
}
