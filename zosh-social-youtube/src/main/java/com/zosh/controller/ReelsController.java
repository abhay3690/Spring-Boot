package com.zosh.controller;

import com.zosh.model.Reels;
import com.zosh.model.User;
import com.zosh.service.ReelsService;
import com.zosh.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReelsController {
    private final ReelsService reelsService;
    private final UserService userService;
    @PostMapping("/api/reels")
    public Reels createReels(@RequestBody Reels reel, @RequestHeader("Authorization") String jwt){
        User reqUser = userService.findUserByJwt(jwt);
        Reels createdReels = reelsService.createReels(reel,reqUser);
        return createdReels;
    }
    @GetMapping("/api/reels")
    public List<Reels> findAllReels( ){
        List<Reels> reels = reelsService.findAllReels();
        return reels;
    }
    @GetMapping("/api/reels/user/{userId}")
    public List<Reels> findUsersReels(@PathVariable Integer userId ) throws Exception {
        List<Reels> reels = reelsService.findUserReels(userId);
        return reels;
    }
}
