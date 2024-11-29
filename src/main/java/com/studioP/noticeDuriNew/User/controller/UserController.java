package com.studioP.noticeDuriNew.User.controller;

import com.studioP.noticeDuriNew.User.entity.dto.LoginForm;
import com.studioP.noticeDuriNew.User.entity.dto.RegisterForm;
import com.studioP.noticeDuriNew.User.entity.User;
import com.studioP.noticeDuriNew.User.service.UserService;
import com.studioP.noticeDuriNew.utils.Const.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Value("${kakao.client_id}")
    private String client_id;

    @Value("${kakao.redirect_uri}")
    private String redirect_uri;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("form", new LoginForm());
        model.addAttribute("kakaoLoginLocation", "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=" + client_id + "&redirect_uri=" + redirect_uri);
        return "users/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("form") LoginForm form, HttpServletRequest request) {
        User user = userService.login(form.getLoginId(), form.getPassword());
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, user);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(@ModelAttribute("form") RegisterForm form) {
        //todo 학과 선택 (Department)
//            List<University> universities = universityService.findAllByOrderByNameAsc();
//
//            model.addAttribute("universities", universities);
        return "users/register";
    }

    @PostMapping(value = {"/register", "/callback"})
    public String register(@Valid @ModelAttribute("form") RegisterForm form, HttpServletRequest request) {
        User user = userService.register(form);
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, user);
        return "redirect:/";
    }

    @GetMapping("/findAccount")
    public String findAccount() {
        return "users/findAccount";
    }

    @GetMapping("/findId")
    @ResponseBody
    public List<String> findId(String email) {
        List<User> users = userService.findByEmail(email);
        List<String> loginIdList = new ArrayList<>();
        for (User user : users) {
            loginIdList.add(user.getLoginId());
        }

        return loginIdList;
    }

    @GetMapping("/findPassword")
    @ResponseBody
    public String findPassword(String loginId) {
        User user = userService.findByLoginId(loginId);
        String newPassword = UUID.randomUUID().toString().substring(5);
        user.changePassword(newPassword);
        return newPassword;
    }

    /*========== Utils ==========*/

    @GetMapping("/existsLoginId")
    @ResponseBody
    public Boolean existsLoginId(String loginId) {
        return userService.existsLoginId(loginId);
    }
}
