package com.hospital.management.dto.request.user;

import java.util.Date;
import java.util.List;

public class UserRequestDto {

    private Long id;
    private String name;
    private String type;
    private String email;
    private String mobile;
    private String password;
    private Date dateOfBirth;
    private Long specialityId;
    private List<Long> list;

    public UserRequestDto(String name, String type, String email, String mobile,
                          String password, Date dateOfBirth, Long specialityId, List<Long> list) {
        this.name = name;
        this.type = type;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.specialityId = specialityId;
        this.list = list;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public Long getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Long specialityId) {
        this.specialityId = specialityId;
    }

    public List<Long> getList() {
        return list;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }
}
