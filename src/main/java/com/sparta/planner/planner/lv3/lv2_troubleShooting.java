package com.sparta.planner.planner.lv3;
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
포스트맨 통해서 입력값이 잘 들어가나 확인해보니 아래 에러가 발생했습니다.

ERROR 52564 --- [Planner] [nio-8080-exec-8] o.a.c.c.C.[.[.[/].[dispatcherServlet]    :
Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception
[Request processing failed: java.lang.IllegalArgumentException: Timestamp format must be yyyy-mm-dd hh:mm:ss[.fffffffff]] with root cause


*/
