package com.example.hospitalmanagement.services;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospitalmanagement.entities.DoctorEntity;
import com.example.hospitalmanagement.models.DoctorModel;
import com.example.hospitalmanagement.repositories.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public void addDoctor(DoctorModel doctorModel) {
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setDoctor_id(doctorModel.getDoctor_id());
        doctorEntity.setFullName(doctorModel.getFullName());
        doctorEntity.setDob(doctorModel.getDob());
        doctorEntity.setQualification(doctorModel.getQualification());
        doctorEntity.setSpecialist(doctorModel.getSpecialist());
        doctorEntity.setEmail(doctorModel.getEmail());
        doctorEntity.setMobno(doctorModel.getMobno());
        doctorEntity.setPassword(doctorModel.getPassword());

        doctorRepository.save(doctorEntity);
    }

    public DoctorModel getDoctorById(int doctorId) {
        DoctorEntity doctorEntity= doctorRepository.findById(doctorId).orElse(null);
        return convertToModel(doctorEntity);
    }

    public void updateDoctor(int doctorId, DoctorModel doctorModel) {
        DoctorEntity doctorEntity = doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));
        doctorEntity.setFullName(doctorModel.getFullName());
        doctorEntity.setDob(doctorModel.getDob());
        doctorEntity.setQualification(doctorModel.getQualification());
        doctorEntity.setSpecialist(doctorModel.getSpecialist());
        doctorEntity.setEmail(doctorModel.getEmail());
        doctorEntity.setMobno(doctorModel.getMobno());
        doctorEntity.setPassword(doctorModel.getPassword());

        doctorRepository.save(doctorEntity);
    }

    public void deleteDoctor(int doctorId) {
        doctorRepository.deleteById(doctorId);
    }

    public List<DoctorModel> getAllDoctors() {
        List<DoctorEntity> doctorEntities = doctorRepository.findAll();

        List<DoctorModel> doctorModels = doctorEntities.stream()
            .map(doctorEntity -> {
                DoctorModel doctorModel = new DoctorModel();
                doctorModel.setDoctor_id(doctorEntity.getDoctor_id());
                doctorModel.setFullName(doctorEntity.getFullName());
                doctorModel.setDob(doctorEntity.getDob());
                doctorModel.setQualification(doctorEntity.getQualification());
                doctorModel.setSpecialist(doctorEntity.getSpecialist());
                doctorModel.setEmail(doctorEntity.getEmail());
                doctorModel.setMobno(doctorEntity.getMobno());
                doctorModel.setPassword(doctorEntity.getPassword());
                return doctorModel;
            })
            .collect(Collectors.toList());

        return doctorModels;
    }
    
    private DoctorModel convertToModel(DoctorEntity doctorEntity) {
        DoctorModel doctorModel = new DoctorModel();
        doctorModel.setDoctor_id(doctorEntity.getDoctor_id());
        doctorModel.setFullName(doctorEntity.getFullName());
        doctorModel.setDob(doctorEntity.getDob());
        doctorModel.setQualification(doctorEntity.getQualification());
        doctorModel.setSpecialist(doctorEntity.getSpecialist());
        doctorModel.setEmail(doctorEntity.getEmail());
        doctorModel.setMobno(doctorEntity.getMobno());
        doctorModel.setPassword(doctorEntity.getPassword());
        return doctorModel;
    }

}
