package com.sparta.planner.planner.lv4.dto;

import com.sparta.planner.planner.lv4.entity.Plan;
import lombok.Getter;
import java.util.Date;

@Getter
public class PlanResponseDto {
    private Long id;
    private Date creationDate;
    private Date modifiedDate;

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
        this.startTime = String.valueOf(plan.getStartTime());
        this.endTime = String.valueOf(plan.getEndTime());
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