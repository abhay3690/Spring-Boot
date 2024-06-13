package com.abhay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhay.models.Video;

public interface VideoRepository extends JpaRepository<Video, Integer>{

}
