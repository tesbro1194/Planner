package com.sparta.planner.planner.lv4.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class User {
    // 테이블 작성 시 `CURRENT_TIMESTAMP` 로 설정.
    private Date creationDate;
    private Date modifiedDate;
    // 입력 받아야 하는 값
    private String userName;
    private Long identificationNumber;
    private String eMail;
}
