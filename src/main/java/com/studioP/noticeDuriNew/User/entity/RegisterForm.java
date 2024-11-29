package com.studioP.noticeDuriNew.User.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterForm {

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String password;

    @NotEmpty
    private String name;

    @NotEmpty
    @Email
    private String email;

//    @NotEmpty
//    private Campus campus;
//
//    @NotEmpty
//    private Department department;

}
