package com.zosh.controller;

import com.zosh.model.Comment;
import com.zosh.model.User;
import com.zosh.service.CommentService;
import com.zosh.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final UserService userService;
    @PostMapping("/api/comments/post/{postId}")
    public Comment createComment(@RequestBody Comment comment, @RequestHeader("Authorization") String jwt, @PathVariable Integer postId) throws Exception {
        User user = userService.findUserByJwt(jwt);
        Comment createdComment = commentService.createComment(comment,postId,user.getId());
        return createdComment;
    }
    @PutMapping("/api/comments/like/{commentId}")
    public Comment likeComment( @RequestHeader("Authorization") String jwt, @PathVariable Integer commentId) throws Exception {
        User user = userService.findUserByJwt(jwt);
        Comment likedComment = commentService.likeComment(commentId,user.getId());
        return likedComment;
    }
}
