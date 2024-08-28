package com.zosh.controller;

import com.zosh.model.Post;
import com.zosh.response.ApiResponse;
import com.zosh.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {
    private final PostService postService;
    @PostMapping("/posts/user/{userId}")
    public ResponseEntity<Post> createPost(@RequestBody Post post, @PathVariable Integer userId) throws Exception {
        Post createdPost = postService.createNewPost(post, userId);
        return new ResponseEntity<>(createdPost, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/posts/{postId}/user/{userId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId, @PathVariable Integer userId) throws Exception {
        String message = postService.deletePost(postId,userId);
        ApiResponse res = new ApiResponse(message,true);
        return new ResponseEntity<ApiResponse>(res,HttpStatus.OK);
    }
    @GetMapping("/posts/{postId}")
    public ResponseEntity<Post> findPostByIdHandler(@PathVariable Integer postId) throws Exception {
        Post post = postService.findPostById(postId);
        return new ResponseEntity<>(post,HttpStatus.ACCEPTED);
    }
    @GetMapping("/posts/user/{userId}")
    public ResponseEntity<List<Post>> findUsersPost(@PathVariable Integer userId){
        List<Post> posts = postService.findPostByUserId(userId);
        return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
     }
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> findAllPost(){
        List<Post> posts = postService.findAllPost();
        return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
    }
    @PutMapping("/posts/save/{postId}/user/{userId}")
    public ResponseEntity<Post> savedPostIdHandler(@PathVariable Integer postId, @PathVariable Integer userId) throws Exception {
        Post post = postService.savedPost(postId,userId);
        return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
    }
    @PutMapping("/posts/like/{postId}/user/{userId}")
    public ResponseEntity<Post> likePostIdHandler(@PathVariable Integer postId, @PathVariable Integer userId) throws Exception {
        Post post = postService.LikePost(postId,userId);
        return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
    }

 }
