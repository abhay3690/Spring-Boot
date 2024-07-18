package com.projects.service.hospital;

import com.projects.dto.HospitalDto;
import com.projects.entity.Hospital;
import com.projects.repository.HosptitalRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService{
    private final HosptitalRepo hospitalRepo;
    @Override
    public HospitalDto createhospital(HospitalDto hospitalDto) {
        Hospital hospital = new Hospital();
        BeanUtils.copyProperties(hospitalDto,hospital);
        Hospital sh = hospitalRepo.save(hospital);
        HospitalDto savedHospital = new HospitalDto();
        BeanUtils.copyProperties(sh,savedHospital);
        return savedHospital;
    }
}
