package com.thinkconstructive.rest_demo.repository;

import com.thinkconstructive.rest_demo.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CloudVendorRepo extends JpaRepository<CloudVendor,String> {
}
