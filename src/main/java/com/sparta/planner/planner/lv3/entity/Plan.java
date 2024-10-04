package com.sparta.planner.planner.lv3.entity;
import com.sparta.planner.planner.lv3.dto.PlanRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Plan {
    private Long id;
    private Date creationDate;
    private Date modifiedDate;

    private String userName;
    private String pw;
    private String shouldDo;
    private LocalDateTime startTime;  // startTime은 LocalDateTime
    private LocalDateTime endTime;    // endTime은 LocalDateTime

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Plan(PlanRequestDto requestDto) {
        this.userName = requestDto.getUserName();
        this.pw = requestDto.getPw();
        this.shouldDo = requestDto.getShouldDo();

        // 커스텀 포맷을 사용하여 문자열을 LocalDateTime으로 변환
        this.startTime = LocalDateTime.parse(requestDto.getStartTime(), formatter);
        this.endTime = LocalDateTime.parse(requestDto.getEndTime(), formatter);
    }
}