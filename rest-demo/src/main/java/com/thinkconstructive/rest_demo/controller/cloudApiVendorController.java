package com.thinkconstructive.rest_demo.controller;

import com.thinkconstructive.rest_demo.model.CloudVendor;
import com.thinkconstructive.rest_demo.response.ResponseHandler;
import com.thinkconstructive.rest_demo.service.CloudVendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
@RequiredArgsConstructor
public class cloudApiVendorController {
    @Autowired
    private CloudVendorService cloudVendorService;
    @GetMapping("/{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return ResponseHandler.responseBuilder("Requested vendor details are given here", HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
    }
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails(){
        return cloudVendorService.getAllCloudVendor();
    }
    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "ClodVendor created Successfully ";
    }
    @PutMapping("/{vendorId}")
    public String updateCloudVendorDetails(@PathVariable String vendorId,@RequestBody CloudVendor cloudVendor) {
        System.out.println(" controller "+cloudVendor.getVendorName()+" "+vendorId);
        cloudVendorService.updateCloudVendor(vendorId,cloudVendor);
        return "cloudVendor updated Successfully";
    }
    @DeleteMapping("/{vendorId}")
    public String deleteClodVendorDetails(@PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud vendor deleted successfully";
    }
}
