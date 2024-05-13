package net.abhay.blog.services;

import java.util.List;

import net.abhay.payloads.PostDto;

public interface PostService {

	// create
	
	PostDto createPost(PostDto postDto,int userId,int categoryId);
	
	// update
	PostDto updatePost(PostDto postDto,int postId);
	
	// delete
	void deletePost(int postId);
	
	// get single Post
	PostDto getPostById(PostDto postDto,int postId);
	
	//get all
	List<PostDto> getAllPost();
	
	// get All Post By Category
	List<PostDto> getPostsByCategory(int categoryId);
	
	// get All posts By User
	List<PostDto> getPostsByUser(int userId);
	
	// search posts
	List<PostDto> searchPosts(String keyword);
}