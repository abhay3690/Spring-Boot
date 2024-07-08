package com.thinkconstructive.rest_demo.service;

import com.thinkconstructive.rest_demo.model.CloudVendor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(String vendorId,CloudVendor cloudVendor);
    public String deleteCloudVendor(String cloudVendorId);
    public CloudVendor getCloudVendor(String cloudVendorId);
    public List<CloudVendor> getAllCloudVendor();
}
