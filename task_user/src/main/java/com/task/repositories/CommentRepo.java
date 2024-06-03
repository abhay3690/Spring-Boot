package com.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.modal.Comment;


public interface CommentRepo extends JpaRepository<Comment, Integer>{

}

