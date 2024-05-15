package net.abhay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.abhay.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
