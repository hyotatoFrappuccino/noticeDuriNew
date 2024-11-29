package com.studioP.noticeDuriNew.User.controller;

import com.studioP.noticeDuriNew.User.entity.LoginForm;
import com.studioP.noticeDuriNew.User.entity.RegisterForm;
import com.studioP.noticeDuriNew.User.entity.User;
import com.studioP.noticeDuriNew.User.service.UserService;
import com.studioP.noticeDuriNew.utils.Const.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/login")
    public String login(Model model) {
        model.addAttribute("form", new LoginForm());
        return "users/login";
    }

    @PostMapping("/users/login")
    public String login(@Valid @ModelAttribute("form") LoginForm form, HttpServletRequest request) {
        User user = userService.login(form.getLoginId(), form.getPassword());
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, user);
        return "redirect:/";
    }

    @GetMapping("/users/register")
    public String register(@ModelAttribute("form") RegisterForm form) {
        return "users/register";
    }

    @PostMapping("/users/register")
    public String register(@Valid @ModelAttribute("form") RegisterForm form, HttpServletRequest request) {
        User user = userService.register(form);
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, user);
        return "redirect:/";
    }

    @GetMapping("/users/existsLoginId")
    @ResponseBody
    public Boolean existsLoginId(String loginId) {
        return userService.existsLoginId(loginId);
    }
}
