package net.abhay.services.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.abhay.blog.services.PostService;
import net.abhay.entities.Category;
import net.abhay.entities.Post;
import net.abhay.entities.User;
import net.abhay.exceptions.ResourceNotFoundException;
import net.abhay.payloads.PostDto;
import net.abhay.repositories.CategoryRepo;
import net.abhay.repositories.PostRepo;
import net.abhay.repositories.UserRepo;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postDto, int userId, int categoryId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User ", "User id", userId));

		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category ", "Category id", categoryId));

		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setCategory(category);
		post.setUser(user);
		
		Post newPost = this.postRepo.save(post);
		
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, int postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(int postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PostDto getPostById(PostDto postDto, int postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostsByCategory(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostsByUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	

}