package com.projects.repository;

import com.projects.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HosptitalRepo extends JpaRepository<Hospital,Long> {
}
