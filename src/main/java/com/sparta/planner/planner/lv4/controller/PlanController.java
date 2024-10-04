package com.sparta.planner.planner.lv4.controller;

import com.sparta.planner.planner.lv4.dto.PlanRequestDto;
import com.sparta.planner.planner.lv4.dto.PlanResponseDto;
import com.sparta.planner.planner.lv4.dto.UserRequestDto;
import com.sparta.planner.planner.lv4.dto.UserResponseDto;
import com.sparta.planner.planner.lv4.service.PlanService;
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
    @PatchMapping("/update/{id}/{pw}")
    public Long updatePlan(@PathVariable Long id, @PathVariable String pw, @RequestBody PlanRequestDto requestDto) {
        return planService.updatePlan(id, pw, requestDto);
    }
    @DeleteMapping("/delete/{id}/{pw}")
    public Long deletePlan(@PathVariable Long id, @PathVariable String pw) {
        return planService.delete(id, pw);
    }

    @PostMapping("/join")
    public UserResponseDto join(@RequestBody UserRequestDto requestDto) {
        return planService.join(requestDto);
    }
    @PostMapping("/login")
    public UserResponseDto login(@RequestBody UserRequestDto requestDto) {
        return planService.login(requestDto);
    }
}