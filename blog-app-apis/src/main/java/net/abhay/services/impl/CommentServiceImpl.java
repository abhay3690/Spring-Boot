package net.abhay.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import net.abhay.blog.services.CommentService;
import net.abhay.entities.Comment;
import net.abhay.entities.Post;
import net.abhay.exceptions.ResourceNotFoundException;
import net.abhay.payloads.CommentDto;
import net.abhay.repositories.CommentRepo;
import net.abhay.repositories.PostRepo;
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final PostRepo postRepo;

	private final CommentRepo commentRepo;

	private final ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment = this.commentRepo.save(comment);
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentID) {
		Comment com = this.commentRepo.findById(commentID)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "comment id", commentID));
		this.commentRepo.delete(com);
	}

}
