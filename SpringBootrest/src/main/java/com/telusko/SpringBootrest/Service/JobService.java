package com.telusko.SpringBootrest.Service;

import com.telusko.SpringBootrest.Repo.JobRepo;
import com.telusko.SpringBootrest.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService
{
    public JobRepo repo;

    @Autowired
    public void setRepo(JobRepo repo) {
        this.repo = repo;
    }
    public void addJob(JobPost jobPost) {
        repo.addJobs(jobPost);

    }
    public List<JobPost> getAllJobs(){
       return  repo.getalljobs();

    }

    public JobPost getJob(int PosstId) {
        return repo.getJob(PosstId);
    }

    public void updateJob(JobPost jobPost) {
        repo.updateJob(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteJob(postId);
    }
}
