package com.FirstProject.Job.Application.job;
import jakarta.persistence.*;

@Entity
@Table(name = "Job_Table")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //automatically manage ids by auto incrementing
    private Long id;
    private String description;
    private String title;
    private String minSalary;
    private String maxSalary;
    private String location;

    //no argument constructor is a need for jp entities(default const)
    public Job() {
    }

    public Job(Long id, String description, String title,
               String minSalary, String maxSalary, String location) {

        this.id = id;
        this.description = description;
        this.title = title;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
