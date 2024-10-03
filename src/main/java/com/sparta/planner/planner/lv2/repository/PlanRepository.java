package com.sparta.planner.planner.lv2.repository;

import com.sparta.planner.planner.lv2.dto.PlanResponseDto;
import com.sparta.planner.planner.lv2.entity.Plan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public class PlanRepository {
    private final JdbcTemplate jdbcTemplate;
    public PlanRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Plan save(Plan plan) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO plan (creationDate, userName, pw, shoulDo, startTime, endTime) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update( con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);

            LocalDateTime now = LocalDateTime.now();
            preparedStatement.setTimestamp(1, Timestamp.valueOf(now));
            preparedStatement.setString(2, plan.getUserName());
            preparedStatement.setString(3, plan.getPw());
            preparedStatement.setString(4, plan.getShouldDo());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(plan.getStartTime())); // LocalDateTime -> Timestamp
            preparedStatement.setTimestamp(6, Timestamp.valueOf(plan.getEndTime()));   // LocalDateTime -> Timestamp

            return preparedStatement;
        }, keyHolder);

        // DB Insert 후 받아온 기본키 확인
        Long id = keyHolder.getKey().longValue();
        plan.setId(id);
        return plan;
    }

    public List<PlanResponseDto> findAll() {
        // DB 조회
        String sql = "SELECT * FROM plan";

        return jdbcTemplate.query(sql, new RowMapper<PlanResponseDto>() {
            @Override
            public PlanResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                Long id = rs.getLong("id");
                Date creationDate = rs.getDate("creationDate");
                String userName = rs.getString("userName");
                String pw = rs.getString("pw");
                String shouldDo = rs.getString("shouldDo");
                String startTime = rs.getString("startTime");
                String endTime = rs.getString("endTime");
                return new PlanResponseDto(id, creationDate, userName, pw, shouldDo, startTime, endTime);
            }
        });
    }

    // 아래 findOne() 메서드는 지피티가 알려줬습니다.
    public Plan findOne(Long id) {
        String sql = "SELECT * FROM plan WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Long[]{id}, new RowMapper<Plan>() {
            @Override
            public Plan mapRow(ResultSet rs, int rowNum) throws SQLException {
                Plan plan = new Plan();
                plan.setId(rs.getLong("id"));
                plan.setCreationDate(rs.getDate("creationDate"));
                plan.setUserName(rs.getString("userName"));
                plan.setPw(rs.getString("pw"));
                plan.setShouldDo(rs.getString("shouldDo"));
                plan.setStartTime(rs.getString("startTime"));
                plan.setEndTime(rs.getString("endTime"));
                return plan;
            }
        });
    }
}