package com.sparta.planner.planner.lv3.controller;

import com.sparta.planner.planner.lv3.dto.PlanRequestDto;
import com.sparta.planner.planner.lv3.dto.PlanResponseDto;
import com.sparta.planner.planner.lv3.service.PlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlanController {

    private final PlanService planService;
    public PlanController(PlanService planService) {
        this.planService = planService;
    }
    @PostMapping("/post")
    public PlanResponseDto createPlan(@RequestBody PlanRequestDto requestDto) {
        return planService.createPlan(requestDto);
    }
    @GetMapping("/getAll")
    public List<PlanResponseDto> getAll() {
        return planService.getAll();
    }
    @GetMapping("/getPlan/{id}")
    public PlanResponseDto getPlan(@PathVariable Long id) {
        return planService.getPlan(id);
    }
    @PutMapping("/update/{id}")
    public Long updatePlan(@PathVariable Long id, @RequestBody PlanRequestDto requestDto) {
        return planService.updatePlan(id, requestDto);
    }
}