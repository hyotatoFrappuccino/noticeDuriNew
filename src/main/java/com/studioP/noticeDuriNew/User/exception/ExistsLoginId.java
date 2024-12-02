package com.studioP.noticeDuriNew.User.exception;

import com.studioP.noticeDuriNew.User.entity.dto.RegisterForm;
import lombok.Getter;

@Getter
public class ExistsLoginId extends RuntimeException {

    private final RegisterForm form;

    public ExistsLoginId(String message, RegisterForm form) {
        super(message);
        this.form = form;
    }

}
