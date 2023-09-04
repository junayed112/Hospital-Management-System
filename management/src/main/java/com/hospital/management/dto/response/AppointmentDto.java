package com.hospital.management.dto.response;

import java.util.Date;

public class AppointmentDto {
    private Long id;
    private Date date;
    private Long doctorId;
    private Long timeSlotId;
    private Long patientId;
    private String status;
    public AppointmentDto() {
    }

    public AppointmentDto(Long id, Date date, Long doctorId, Long timeSlotId, Long patientId, String status) {
        this.id = id;
        this.date = date;
        this.doctorId = doctorId;
        this.timeSlotId = timeSlotId;
        this.patientId = patientId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(Long timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
