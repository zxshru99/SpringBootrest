package com.telusko.SpringBootrest;

import com.telusko.SpringBootrest.Service.JobService;
import com.telusko.SpringBootrest.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloRestController {
    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
     return service.getAllJobs() ;
    }

    @GetMapping("jobPosts/{PostId}")
    public JobPost getJob(@PathVariable("PostId") int PostId){
        return service.getJob(PostId);

    }
    @PostMapping("jobPosts")
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());

    }
    @PutMapping("jobPosts")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }
    @DeleteMapping("jobPosts/{postId}")
    public String deleteJob(@PathVariable int postId){
        service.deleteJob(postId);
        return "Deleted"+postId;
    }

    @PostMapping("load")
    public String loadData() {
        service.load();
        return "success";
    }
  @GetMapping("jobPosts/Keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable String keyword){
        return service.searchByKeyword(keyword);
  }

}


