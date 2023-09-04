package com.hospital.management.dto.request.user;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class DoctorTimeSlotRequestDto {
    private Long doctorId;
    private Long timeSlotId;
    private Date date;
    private String appointmentBooked;
    public DoctorTimeSlotRequestDto() {
    }

    public DoctorTimeSlotRequestDto(Long doctorId, Long timeSlotId, Date date, String appointmentBooked) {
        this.doctorId = doctorId;
        this.timeSlotId = timeSlotId;
        this.date = date;
        this.appointmentBooked = appointmentBooked;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAppointmentBooked() {
        return appointmentBooked;
    }

    public void setAppointmentBooked(String appointmentBooked) {
        this.appointmentBooked = appointmentBooked;
    }
}
