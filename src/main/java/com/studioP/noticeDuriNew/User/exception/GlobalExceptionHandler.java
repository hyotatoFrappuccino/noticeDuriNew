package com.studioP.noticeDuriNew.User.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    public GlobalExceptionHandler() {
    }

    @ExceptionHandler(LoginFailedException.class)
    public String handleLoginFailedException() {
        return "redirect:/members/login";
    }
}
