package com.sparta.planner.planner.lv4.service;

import com.sparta.planner.planner.lv4.dto.PlanRequestDto;
import com.sparta.planner.planner.lv4.dto.PlanResponseDto;
import com.sparta.planner.planner.lv4.dto.UserRequestDto;
import com.sparta.planner.planner.lv4.dto.UserResponseDto;
import com.sparta.planner.planner.lv4.entity.Plan;
import com.sparta.planner.planner.lv4.entity.User;
import com.sparta.planner.planner.lv4.repository.PlanRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlanService {
    private final PlanRepository planRepository;
    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public PlanResponseDto createPlan(PlanRequestDto requestDto) {
        Plan plan = new Plan(requestDto);
        Plan savePlan = planRepository.save(plan);
        PlanResponseDto planResponseDto = new PlanResponseDto(plan);
        return planResponseDto;
    }

    public List<PlanResponseDto> getAll() {
        return planRepository.findAll();
    }

    public PlanResponseDto getPlan(Long id) {
        Plan plan = planRepository.findOne(id);
        return new PlanResponseDto(plan);
    }
    public Long updatePlan(Long id, String pw, PlanRequestDto requestDto) {
        Plan plan = planRepository.identifyForPlan(id, pw);
        if (plan != null) {
            planRepository.updatePlan(id, requestDto);
            return id;
        } else{
            throw new IllegalArgumentException("선택한 일정은 존재하지 않습니다.");
        }
    }
    public Long delete(Long id, String pw) {
        Plan plan = planRepository.identifyForPlan(id, pw);
        if (plan != null) {
            planRepository.delete(id);
            return id;
        } else {
            throw new IllegalArgumentException("선택한 일정은 존재하지 않습니다.");
        }
    }

    public UserResponseDto join(UserRequestDto requestDto) {
        User user = new User(requestDto);
        User joinedUser = planRepository.join(user);
        UserResponseDto userResponseDto = new UserResponseDto(joinedUser);
        return userResponseDto;
    }

    public UserResponseDto login(UserRequestDto requestDto) {
        String id = requestDto.getUserId();
        String pw = requestDto.getPw();
        UserResponseDto userResponseDto = planRepository.identifyForUser(id, pw);

        if (userResponseDto != null) {
            return planRepository.login(requestDto);
        } else {
            throw new IllegalArgumentException("ID와 PW를 확인하세요");
        }
    }
}