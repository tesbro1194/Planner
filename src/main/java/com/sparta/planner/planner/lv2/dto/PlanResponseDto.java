package com.sparta.planner.planner.lv2.dto;

import com.sparta.planner.planner.lv2.entity.Plan;

import java.time.LocalDateTime;
import java.util.Date;

public class PlanResponseDto {
    private Long id;
    private Date creationDate;

    private String userName;
    private String pw;
    private String shouldDo;
    private String startTime;
    private String endTime;

    public PlanResponseDto(Plan plan) {
        this.id = plan.getId();
        this.creationDate = plan.getCreationDate();
        this.userName = plan.getUserName();
        this.pw = plan.getPw();
        this.shouldDo = plan.getShouldDo();
        this.startTime = plan.getStartTime();
        this.endTime = plan.getEndTime();
    }

    public PlanResponseDto(Long id, Date creationDate, String userName, String pw, String shouldDo, String startTime, String endTime) {
        this.id = id;
        this.creationDate = creationDate;
        this.userName = userName;
        this.pw = pw;
        this.shouldDo = shouldDo;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}