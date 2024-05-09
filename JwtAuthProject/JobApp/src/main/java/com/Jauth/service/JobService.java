package com.Jauth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jauth.model.JobPost;
import com.Jauth.repo.JobRepo;

@Service
public class JobService {

	@Autowired
	public JobRepo repo;
	
	// method to return all JobPosts
		public List<JobPost> getAllJobs() {
			return repo.findAll();

		}

		// method to add a jobPost
		public void addJobPost(JobPost jobPost) {
			repo.save(jobPost);

		}

		public JobPost getJob(int postId) {
			return repo.findById(postId).orElse(new JobPost());
		}

		public void updateJob(JobPost jobPost) {
			repo.save(jobPost);

		}

		public void deleteJob(int postId) {
			// TODO Auto-generated method stub
			repo.deleteById(postId);;
		}
		
		public List<JobPost> search(String keyword){
			return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
		}

//	// method to return all JobPosts
//	public List<JobPost> getAllJobs() {
//		return repo.getAllJobs();
//
//	}
//
//	// method to add a jobPost
//	public void addJobPost(JobPost jobPost) {
//		repo.addJobPost(jobPost);
//
//	}
//
//	public JobPost getJob(int postId) {
//		return repo.getJob(postId);
//	}
//
//	public void updateJob(JobPost jobPost) {
//		repo.updateJob(jobPost);
//
//	}
//
//	public void deleteJob(int postId) {
//		// TODO Auto-generated method stub
//		repo.deleteJob(postId);
//	}
}
