package com.sparta.planner.planner.lv4.repository;

import com.sparta.planner.planner.lv4.dto.PlanRequestDto;
import com.sparta.planner.planner.lv4.dto.PlanResponseDto;
import com.sparta.planner.planner.lv4.entity.Plan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Repository
public class PlanRepository {
    private final JdbcTemplate jdbcTemplate;
    public PlanRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Plan save(Plan plan) {
        String sql = "INSERT INTO plan (creationDate, userName, pw, shouldDo, startTime, endTime) VALUES (now(), ?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, plan.getUserName());
            preparedStatement.setString(2, plan.getPw());
            preparedStatement.setString(3, plan.getShouldDo());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(plan.getStartTime()));
            preparedStatement.setTimestamp(5, Timestamp.valueOf(plan.getEndTime()));
            return preparedStatement;
        }, keyHolder);

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
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Plan>() {
            @Override
            public Plan mapRow(ResultSet rs, int rowNum) throws SQLException {
                Plan plan = new Plan();
                plan.setId(rs.getLong("id"));
                plan.setCreationDate(rs.getDate("creationDate"));
                plan.setUserName(rs.getString("userName"));
                plan.setPw(rs.getString("pw"));
                plan.setShouldDo(rs.getString("shouldDo"));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                plan.setStartTime(LocalDateTime.parse(rs.getString("startTime"), formatter));
                plan.setEndTime(LocalDateTime.parse(rs.getString("endTime"), formatter));
                return plan;
            }
        });
    }

    public void updatePlan(Long id, PlanRequestDto requestDto) {
        String sql = "UPDATE plan SET userName = ?, shouldDo = ? WHERE id = ?";
        jdbcTemplate.update(sql, requestDto.getUserName(), requestDto.getShouldDo(), id);
    }
    @Transactional
    public void delete(Long id) {
        String sql = "DELETE FROM plan WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    public Plan identify(Long id, String pw) {
        String sql = "SELECT * FROM plan WHERE id = ? and pw = ?";

        return jdbcTemplate.query(sql, resultSet -> {
            if (resultSet.next()) {
                Plan plan = new Plan();
                plan.setUserName(resultSet.getString("userName"));
                plan.setShouldDo(resultSet.getString("shouldDo"));
                return plan;
            } else {
                return null;
            }
        }, id, pw);
    }
}