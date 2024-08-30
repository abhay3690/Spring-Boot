package com.zosh.service;

import com.zosh.model.Reels;
import com.zosh.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReelsService {
    public Reels createReels(Reels reels, User user);
    public List<Reels> findAllReels();
    public List<Reels> findUserReels(Integer userId) throws Exception;
}
