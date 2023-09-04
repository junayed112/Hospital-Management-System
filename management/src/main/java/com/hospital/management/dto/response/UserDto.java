package com.hospital.management.dto.response;

import com.hospital.management.entity.Speciality;
import com.hospital.management.entity.TimeSlot;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class UserDto {

    private Long id;
    private String name;
    private String type;
    private String email;
    private String mobile;
    private Date dateOfBirth;
    private String token;
    private Speciality speciality;
    private List<TimeSlot> timeSlotList;

    public UserDto() {

    }

    public UserDto(String token) {
        this.token = token;
    }


    public UserDto(Long id, String name, String type, String email, String mobile, Date dateOfBirth, String token,
                   Speciality speciality, List<TimeSlot> timeSlotList) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.email = email;
        this.mobile = mobile;
        this.dateOfBirth = dateOfBirth;
        this.token = token;
        this.speciality = speciality;
        this.timeSlotList = timeSlotList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public List<TimeSlot> getTimeSlotList() {
        return timeSlotList;
    }

    public void setTimeSlotList(List<TimeSlot> timeSlotList) {
        this.timeSlotList = timeSlotList;
    }
}
