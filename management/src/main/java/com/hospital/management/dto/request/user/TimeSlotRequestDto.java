package com.hospital.management.dto.request.user;

import java.sql.Time;

public class TimeSlotRequestDto {
    private Long id;
    private Time startTime;
    private Time endTime;

    public TimeSlotRequestDto() {
    }

    public TimeSlotRequestDto(Time startTime, Time endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
