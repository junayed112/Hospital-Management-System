package com.hospital.management.dto.request.user;

import java.util.Date;

public class AppointmentRequestDto {
    private Date date;
    private Long doctorId;
    private Long timeSlotId;
    private Long patientId;

    public AppointmentRequestDto() {
    }

    public AppointmentRequestDto(Date date, Long doctorId, Long timeSlotId, Long patientId) {
        this.date = date;
        this.doctorId = doctorId;
        this.timeSlotId = timeSlotId;
        this.patientId = patientId;
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

}
