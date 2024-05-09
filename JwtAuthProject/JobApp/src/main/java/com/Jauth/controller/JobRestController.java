package com.Jauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Jauth.model.JobPost;
import com.Jauth.service.JobService;

@RestController
public class JobRestController {
	@Autowired
	JobService jobservice;
	
	@GetMapping("/jobPosts")
	public List<JobPost> getAllJobs() {
		return jobservice.getAllJobs();
	}
	@PostMapping("/jobPost")
	public JobPost addJobs(@RequestBody JobPost post) {
		jobservice.addJobPost(post);
		return jobservice.getJob(post.getPostId());
	}
	
	@GetMapping("jobPost/{postId}")
	public JobPost getjob(@PathVariable("postId") int postId) {
		return jobservice.getJob(postId);
	}
	
	@PutMapping("jobPost")
	public JobPost updateJob(@RequestBody JobPost jobPost) {
		jobservice.updateJob(jobPost);
		return jobservice.getJob(jobPost.getPostId());
	}
	
	@DeleteMapping("jobPost/{postId}")
	public String deleteJob(@PathVariable int postId)
	{
		jobservice.deleteJob(postId);
		return "Deleted";
	}
	@GetMapping("jobPosts/keyword/{keyword}")
	public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
		return jobservice.search(keyword);
	}
}
