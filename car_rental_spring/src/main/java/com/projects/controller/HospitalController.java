package com.projects.controller;

import com.projects.dto.HospitalDto;
import com.projects.service.hospital.HospitalService;
import com.projects.service.hospital.HospitalServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Add")
@RequiredArgsConstructor
@CrossOrigin(origins  = "http://localhost:3000")
public class HospitalController {

    private final HospitalService hospitalService;

    @PostMapping
    public ResponseEntity<HospitalDto> createHospital(@RequestBody HospitalDto hospitalDto){
        System.out.println(hospitalDto.getHAddress()+" "+hospitalDto.getHName());
        HospitalDto createdHospital = hospitalService.createhospital(hospitalDto);
        return ResponseEntity.ok(createdHospital);
    }
}
