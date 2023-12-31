package com.hospital.management.dto.request.user;

public class SpecialityRequestDto {
    private Long id;
    private String name;

    public SpecialityRequestDto() {
    }

    public SpecialityRequestDto(String name) {
        this.name = name;
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
}
