package com.projects.service.hospital;

import com.projects.dto.HospitalDto;
import com.projects.entity.Hospital;
import org.springframework.stereotype.Service;

@Service
public interface HospitalService {
    HospitalDto createhospital(HospitalDto hospitalDto);
}
