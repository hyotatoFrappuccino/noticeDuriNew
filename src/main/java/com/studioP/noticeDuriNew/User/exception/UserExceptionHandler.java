package com.studioP.noticeDuriNew.User.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(LoginFailedException.class)
    public String handleLoginFailedException(LoginFailedException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("loginFail", e.getMessage());
        return "redirect:/users/login";
    }

    @ExceptionHandler(ExistsLoginId.class)
    public String handleExistsLoginId(ExistsLoginId e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("existsLoginId", e.getMessage());
        redirectAttributes.addFlashAttribute("form", e.getForm());
        return "redirect:/users/register";
    }
}
