package com.sparta.planner.planner.lv3;
/*

포스트맨 Patch 메서드와 delete 메서드 모두 실행 안됨.

patch 메서드는 레포지토리의 해당 메서드의 코드 수정 id 위치 수정.

jdbcTemplate.update(sql, id, requestDto.getUserName(), requestDto.getShouldDo());

-> jdbcTemplate.update(sql, requestDto.getUserName(), requestDto.getShouldDo(), id);

포스트맨 delete 에는 레퍼지토리의 해당 메서드에 @Transactional 에노테이션 추가 후 해결.

*/
