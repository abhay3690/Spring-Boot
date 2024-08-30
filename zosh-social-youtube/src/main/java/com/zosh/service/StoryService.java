package com.zosh.service;

import com.zosh.model.Story;
import com.zosh.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoryService {
    public Story createStory(Story story, User user);
    public List<Story> findStoryByUSerId(Integer userId) throws Exception;


}
