package com.FirstProject.Job.Application.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class jobController {

    jobService js;

    //this used instead of autowired(dependency injection)
    public jobController(jobService js) {
        this.js = js;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(js.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add-jobs")
    public ResponseEntity<String> createJobs(@RequestBody Job job){
        js.createJob(job);
        return new ResponseEntity<>("job added successfuly",HttpStatus.CREATED);
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job =js.getJobById(id);
        if(job!=null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }else
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean deleted = js.deleteJobById(id);
        if(deleted){
            return new ResponseEntity<>("job deleted",HttpStatus.NO_CONTENT);

        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id ,
                                            @RequestBody  Job updatedJob){
        boolean updated = js.updateJobById(id,updatedJob);
        if(updated){
            return new ResponseEntity<>("job updated successfully",HttpStatus.OK);
        }else
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
