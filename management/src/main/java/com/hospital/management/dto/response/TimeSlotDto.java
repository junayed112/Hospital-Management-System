package com.hospital.management.dto.response;

import java.sql.Time;

public class TimeSlotDto {
    private Long id;
    private Time startTime;
    private Time endTime;

    public TimeSlotDto() {
    }

    public TimeSlotDto(Long id, Time startTime, Time endTime) {
        this.id = id;
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
