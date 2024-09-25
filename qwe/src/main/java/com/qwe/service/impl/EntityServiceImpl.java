package com.qwe.service.impl;

import com.qwe.modal.Entity;
import com.qwe.service.EntityServidce;
import com.qwe.repositery.EntityRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntityServiceImpl implements EntityServidce {
    private final EntityRepo entityRepo;
    @Override
    public Entity createEntity(Entity entity) {
       Entity newEntity = new Entity();
       newEntity.setId(entity.getId());
       newEntity.setName(entity.getName());
       Entity savedentity = entityRepo.save(newEntity);
        return savedentity;
    }

    @Override
    public List<Entity> getAll() {
        List<Entity> all = this.entityRepo.findAll();
        return all;
    }
}
