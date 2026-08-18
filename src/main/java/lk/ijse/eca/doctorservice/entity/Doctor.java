package lk.ijse.eca.doctorservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "doctors")
public class Doctor {
    @Id
    private String doctorId;
    private String name;
    private String specialty;
    private String hospital;
    private String contactNo;
    private Double consultationFee;
    private String availableDays;

    public Doctor() {
    }

    public Doctor(String doctorId, String name, String specialty, String hospital, String contactNo, Double consultationFee, String availableDays) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialty = specialty;
        this.hospital = hospital;
        this.contactNo = contactNo;
        this.consultationFee = consultationFee;
        this.availableDays = availableDays;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(Double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public String getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(String availableDays) {
        this.availableDays = availableDays;
    }
}
