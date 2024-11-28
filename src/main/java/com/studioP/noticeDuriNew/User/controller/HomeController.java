package com.studioP.noticeDuriNew.User.controller;

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

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping("/members/login")
    public String login(Model model) {
        model.addAttribute("form", new LoginForm());
        return "members/login";
    }

    @PostMapping("/members/login")
    public String login(@Valid @ModelAttribute("form") LoginForm form, HttpServletRequest request) {
        User user = userService.login(form.getLoginId(), form.getPassword());
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, user);
        return "redirect:/";
    }

}
