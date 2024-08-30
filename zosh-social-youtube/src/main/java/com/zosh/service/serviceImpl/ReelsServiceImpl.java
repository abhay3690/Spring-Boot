package com.zosh.service.serviceImpl;

import com.zosh.model.Reels;
import com.zosh.model.User;
import com.zosh.repository.ReelsRepository;
import com.zosh.service.ReelsService;
import com.zosh.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ReelsServiceImpl implements ReelsService {
    private final ReelsRepository reelsRepository;
    private final UserService userService;
    @Override
    public Reels createReels(Reels reels, User user) {
        Reels createReel = new Reels();

        createReel.setTitle(reels.getTitle());
        createReel.setUser(user);
        createReel.setVideo(reels.getVideo());

        return reelsRepository.save(createReel);
    }

    @Override
    public List<Reels> findAllReels() {
        return reelsRepository.findAll();
    }

    @Override
    public List<Reels> findUserReels(Integer userId) throws Exception {
        userService.findUserById(userId);

        return reelsRepository.findByUserId(userId);
    }
}
