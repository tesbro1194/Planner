package com.sparta.planner.planner.lv3.service;

import com.sparta.planner.planner.lv3.dto.PlanRequestDto;
import com.sparta.planner.planner.lv3.dto.PlanResponseDto;
import com.sparta.planner.planner.lv3.entity.Plan;
import com.sparta.planner.planner.lv3.repository.PlanRepository;
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
        Plan plan = planRepository.identify(id, pw);
        if (plan != null) {
            planRepository.updatePlan(id, requestDto);
            return id;
        } else{
            throw new IllegalArgumentException("선택한 일정은 존재하지 않습니다.");
        }
    }
    public Long delete(Long id, String pw) {
        Plan plan = planRepository.identify(id, pw);
        if (plan != null) {
            planRepository.delete(id);
            return id;
        } else {
            throw new IllegalArgumentException("선택한 일정은 존재하지 않습니다.");
        }
    }
}