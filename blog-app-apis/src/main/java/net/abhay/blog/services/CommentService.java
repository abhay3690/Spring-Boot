package net.abhay.blog.services;

import net.abhay.payloads.CommentDto;

public interface CommentService {
	CommentDto createComment(CommentDto commentDto,Integer postId);
	void deleteComment(Integer commentID);
	

}
