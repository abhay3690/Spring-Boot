package com.qwe.repositery;

import com.qwe.modal.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepo extends JpaRepository<Entity, Integer> {

}
