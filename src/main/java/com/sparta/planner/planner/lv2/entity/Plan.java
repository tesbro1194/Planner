package com.sparta.planner.planner.lv2.entity;
import com.sparta.planner.planner.lv2.dto.PlanRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Plan {
    private Long id;
    private Date creationDate;
    // 입력 받는 값
    private String userName;
    private String pw;
    private String shouldDo;
    private String startTime;
    private String endTime;

    public Plan(PlanRequestDto requestDto) {
        this.userName = requestDto.getUserName();
        this.pw = requestDto.getPw();
        this.shouldDo = requestDto.getShouldDo();
        this.startTime = requestDto.getStartTime();
        this.endTime = requestDto.getEndTime();
    }
}