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

    public Long updatePlan(Long id, PlanRequestDto requestDto) {
        Plan plan = planRepository.identifyById(id);

    }
}