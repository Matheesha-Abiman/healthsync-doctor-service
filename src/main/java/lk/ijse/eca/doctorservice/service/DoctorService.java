package lk.ijse.eca.doctorservice.service;

import lk.ijse.eca.doctorservice.dto.DoctorDTO;
import lk.ijse.eca.doctorservice.entity.Doctor;
import lk.ijse.eca.doctorservice.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<DoctorDTO> getAllDoctors() {
        try {
            return doctorRepository.findAll().stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println("[DoctorService] Warning: MongoDB unavailable - " + e.getMessage());
            return List.of();
        }
    }

    public DoctorDTO getDoctorById(String doctorId) {
        try {
            Doctor doctor = doctorRepository.findById(doctorId)
                    .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + doctorId));
            return mapToDTO(doctor);
        } catch (Exception e) {
            System.err.println("[DoctorService] Error getting doctor " + doctorId + ": " + e.getMessage());
            throw new RuntimeException("Doctor lookup error: " + e.getMessage());
        }
    }

    public DoctorDTO createDoctor(DoctorDTO dto) {
        if (dto.getDoctorId() == null || dto.getDoctorId().trim().isEmpty()) {
            dto.setDoctorId("DOC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        }
        Doctor doctor = new Doctor(
                dto.getDoctorId(),
                dto.getName(),
                dto.getSpecialty(),
                dto.getHospital(),
                dto.getContactNo(),
                dto.getConsultationFee(),
                dto.getAvailableDays()
        );
        return mapToDTO(doctorRepository.save(doctor));
    }

    public DoctorDTO updateDoctor(String doctorId, DoctorDTO dto) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + doctorId));

        doctor.setName(dto.getName());
        doctor.setSpecialty(dto.getSpecialty());
        doctor.setHospital(dto.getHospital());
        doctor.setContactNo(dto.getContactNo());
        doctor.setConsultationFee(dto.getConsultationFee());
        doctor.setAvailableDays(dto.getAvailableDays());

        return mapToDTO(doctorRepository.save(doctor));
    }

    public void deleteDoctor(String doctorId) {
        doctorRepository.deleteById(doctorId);
    }

    private DoctorDTO mapToDTO(Doctor doctor) {
        return new DoctorDTO(
                doctor.getDoctorId(),
                doctor.getName(),
                doctor.getSpecialty(),
                doctor.getHospital(),
                doctor.getContactNo(),
                doctor.getConsultationFee(),
                doctor.getAvailableDays()
        );
    }
}
