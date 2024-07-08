package com.thinkconstructive.rest_demo.service.impl;

import com.thinkconstructive.rest_demo.exception.CloudVendorNotFoundException;
import com.thinkconstructive.rest_demo.model.CloudVendor;
import com.thinkconstructive.rest_demo.repository.CloudVendorRepo;
import com.thinkconstructive.rest_demo.service.CloudVendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CloudVendorServiceImpl implements CloudVendorService {
    @Autowired
    private CloudVendorRepo cloudVendorRepo;

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepo.save(cloudVendor);
        return "Suceess";
    }

    @Override
    public String updateCloudVendor(String vendorId,CloudVendor cloudVendor) {

        CloudVendor cloudVendor1 = cloudVendorRepo.findById(vendorId).orElseThrow(() -> new CloudVendorNotFoundException("User not found : " + vendorId));
        cloudVendor1.setVendorName(cloudVendor.getVendorName());
        cloudVendor1.setVendorAddress(cloudVendor.getVendorAddress());
        cloudVendor1.setVendorPhoneNumber(cloudVendor.getVendorPhoneNumber());
        cloudVendorRepo.save(cloudVendor1);
        return "success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
      CloudVendor cloudVendor =  cloudVendorRepo.findById(cloudVendorId).orElseThrow(()-> new CloudVendorNotFoundException("User Not Found!!"+cloudVendorId));
        cloudVendorRepo.delete(cloudVendor);
        return "Sucess";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        return cloudVendorRepo.findById(cloudVendorId).orElseThrow(()-> new CloudVendorNotFoundException("User Not Found!!"+cloudVendorId));
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        return cloudVendorRepo.findAll();
    }
}
