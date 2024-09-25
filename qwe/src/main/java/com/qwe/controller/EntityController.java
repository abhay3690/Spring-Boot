package com.qwe.controller;

import com.qwe.modal.Entity;
import com.qwe.service.EntityServidce;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class EntityController {
    private final EntityServidce entityServidce;
    @PostMapping("/create")
    public ResponseEntity<Entity> createEntity(@RequestBody Entity entity){
        Entity createEntity = this.entityServidce.createEntity(entity);
        return new ResponseEntity<>(createEntity, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Entity>> getAll() {
        List<Entity> all = this.entityServidce.getAll();
        return ResponseEntity.ok(all);
    }
}
