package com.sparta.planner.planner.lv3.dto;

import lombok.Getter;

@Getter
public class PlanRequestDto {
    private String userName;
    private String pw;
    private String shouldDo;
    private String startTime;
    private String endTime;
}
