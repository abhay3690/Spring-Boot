package com.zosh.repository;

import com.zosh.model.Story;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoryRepossitory extends JpaRepository<Story,Integer> {
    public List<Story> findByUserId(Integer userId);
}
