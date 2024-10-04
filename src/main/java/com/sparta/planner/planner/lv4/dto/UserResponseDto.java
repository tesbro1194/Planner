package com.sparta.planner.planner.lv4.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class UserResponseDto {
    private Date creationDate;
    private Date modifiedDate;
    private String userName;
    private Long identificationNumber;
    private String eMail;


}
