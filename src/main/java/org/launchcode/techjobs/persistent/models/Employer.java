package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank
    @Size(min=3, max=100, message= "Location must be between 3 and 100 characters long.")
    private String location;

//    public Employer(String location) {
//        this.location = location;
//    }

//    @OneToMany(mappedBy = "employer")
    @OneToMany
    @JoinColumn(name= "employer_id")
//    @JoinColumn
    private final List<Job> jobs = new ArrayList<>();

    public Employer() {

    }

    public List<Job> getJobs() {
        return jobs;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
