package com.sparta.planner.planner.lv2;
/*

과제를 10월 3일부터 만들기 시작했습니다.

강의에 나온 memo 만들기에서 형식을 그대로 가져와서 이름을 바꾸고, 테이블에 맞춰 끼워넣는 식으로 lv2 를 완성시켰습니다.

그 과정에서 지피티의 도움을 받았습니다. 크게 세 부분에서 도움을 받았는데 아래에 적어두겠습니다.

1. 테이블 생성 및 수정 시 쿼리문 작성할 때

2. PlanRepository 클래스의 save() 의
`preparedStatement.setTimestamp(5, Timestamp.valueOf(plan.getStartTime())); // LocalDateTime -> Timestamp
 preparedStatement.setTimestamp(6, Timestamp.valueOf(plan.getEndTime()));   // LocalDateTime -> Timestamp`

3. PlanRepository 클래스의 findOne() 메서드 부분에서 도움 받았습니다.

모르는 부분은 jdbcTemplate 를 이용해 사용자가 입력한 값이 쿼리문으로 전달되어
create, read, update, delete 되는 원리 입니다.

그냥 강의에서 알려주신대로 순서 맞추고 타입 맞춰서 적어놨습니다. 입력을 잘 받는지 모르겠네요.
포스트맨 통해서 확인하는 방법도 모르겠습니다.
*/
