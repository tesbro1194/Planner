package com.sparta.planner.planner.lv4.dto;

import com.sparta.planner.planner.lv4.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto {
    private Date creationDate;
    private Date modifiedDate;
    private String userName;
    private String userId;
    private String pw;
    private String eMail;


    public UserResponseDto(User user) {
        this.userName = user.getUserName();
        this.userId = user.getUserId();
        this.pw = user.getPw();
        this.eMail = user.getEMail();
    }
}
