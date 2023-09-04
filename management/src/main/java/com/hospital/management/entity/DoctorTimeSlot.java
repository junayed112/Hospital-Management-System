package com.hospital.management.entity;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "doctor_time_slot")
public class DoctorTimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "doctor_id")
    private Long doctorId;
    @Column(name = "time_slot_id")
    private Long timeSlotId;
    @Column(name = "date")
    private Date date;
    @Column(name = "appointment_booked")
    private String appointmentBooked;
    public DoctorTimeSlot() {
    }

    public DoctorTimeSlot(Long id, Long doctorId, Long timeSlotId, Date date, String appointmentBooked) {
        this.id = id;
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

    public String getAppointmentBooked() {
        return appointmentBooked;
    }

    public void setAppointmentBooked(String appointmentBooked) {
        this.appointmentBooked = appointmentBooked;
    }
}
