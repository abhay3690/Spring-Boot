package com.zosh.service.serviceImpl;

import com.zosh.model.Story;
import com.zosh.model.User;
import com.zosh.repository.StoryRepossitory;
import com.zosh.service.StoryService;
import com.zosh.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@AllArgsConstructor
public class SoryServiceImpl implements StoryService {
    private final StoryRepossitory storyRepossitory;
    private final UserService userService;
    @Override
    public Story createStory(Story story, User user) {
        Story createdStory = new Story();
        createdStory.setCaption(story.getCaption());
        createdStory.setImage(story.getImage());
        createdStory.setUser(user);
        createdStory.setTimestamp(LocalDateTime.now());
        return storyRepossitory.save(createdStory);
    }

    @Override
    public List<Story> findStoryByUSerId(Integer userId) throws Exception {
    User user = userService.findUserById(userId);

        return storyRepossitory.findByUserId(userId);
    }
}
