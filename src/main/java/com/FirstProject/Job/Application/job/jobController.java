package com.FirstProject.Job.Application.job;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class jobController {

    jobService js;

    //this used instead of autowired
    public jobController(jobService js) {
        this.js = js;
    }

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return js.findAll();
    }

    @PostMapping("/add-jobs")
    public String createJobs(@RequestBody Job job){
        js.createJob(job);
        return "job added successfuly";
    }
    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable Long id){
        Job job =js.getJobById(id);
        return job;

    }
}
