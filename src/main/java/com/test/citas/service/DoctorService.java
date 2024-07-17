package com.test.citas.service;

import com.test.citas.entity.Doctor;
import com.test.citas.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
