package com.zosh.controller;

import com.zosh.model.Story;
import com.zosh.model.User;
import com.zosh.service.StoryService;
import com.zosh.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StoryController {
    private final StoryService storyService;
    private final UserService userService;
    @PostMapping("/api/story")
    public Story createStory(@RequestBody Story story, @RequestHeader("Authorization") String jwt){
        User reqUser = userService.findUserByJwt(jwt);

        Story createdStory = storyService.createStory(story, reqUser);
        return createdStory;
    }
    @GetMapping("/api/story/user/{userId}")
    public List<Story> findUserStory( @RequestHeader("Authorization") String jwt, @PathVariable Integer userId) throws Exception {
        User reqUser = userService.findUserByJwt(jwt);

        List<Story> stories = storyService.findStoryByUSerId(userId);
        return stories;
    }

}
