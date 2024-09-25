package com.qwe.service;

import com.qwe.modal.Entity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EntityServidce {
    Entity createEntity(Entity entity);
    public List<Entity> getAll();
}
