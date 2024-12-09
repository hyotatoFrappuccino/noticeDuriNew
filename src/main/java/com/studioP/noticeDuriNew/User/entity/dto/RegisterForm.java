package com.studioP.noticeDuriNew.User.entity.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterForm {

    @NotEmpty
    private String loginId;

    private String password;

    @NotEmpty
    private String name;

    @NotEmpty
    @Email
    private String email;

    private Long kakaoId;

    private boolean marketingReceiveAgree;

//    @NotEmpty
//    private Campus campus;
//
//    @NotEmpty
//    private Department department;

}
