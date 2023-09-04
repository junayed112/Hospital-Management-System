package com.hospital.management.dto.request.user;

public class ExternalUserRequestDto {
    private Long id;
    private String name;
    private String mobileNo;

    public ExternalUserRequestDto() {
    }

    public ExternalUserRequestDto(String name, String mobileNo) {
        this.name = name;
        this.mobileNo = mobileNo;
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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
