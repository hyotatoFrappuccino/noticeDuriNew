package com.studioP.noticeDuriNew.User.controller;

import com.studioP.noticeDuriNew.User.entity.dto.RegisterForm;
import com.studioP.noticeDuriNew.User.entity.User;
import com.studioP.noticeDuriNew.User.entity.dto.KakaoUserInfoResponseDto;
import com.studioP.noticeDuriNew.User.exception.KakaoAccountNotFoundException;
import com.studioP.noticeDuriNew.User.service.KakaoService;
import com.studioP.noticeDuriNew.User.service.UserService;
import com.studioP.noticeDuriNew.utils.Const.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class KakaoLoginController {

    private final KakaoService kakaoService;
    private final UserService userService;

    @GetMapping("/users/callback")
    public String kakaoLoginCallback(@RequestParam("code") String code, Model model, HttpServletRequest request) {
        String accessToken = kakaoService.getAccessTokenFromKakao(code);
        KakaoUserInfoResponseDto userInfo = kakaoService.getUserInfo(accessToken);

        Long kakao_id = userInfo.getId();

        User loginUser;

        try {
            loginUser = userService.getUserByKakaoId(kakao_id);
        } catch (KakaoAccountNotFoundException e) {
            // 카카오 계정으로 회원가입
            RegisterForm form = new RegisterForm();
            form.setLoginId(UUID.randomUUID().toString());
            form.setName(userInfo.getKakaoAccount().getProfile().getNickName());
            form.setKakaoId(userInfo.getId());
            form.setEmail(userInfo.getKakaoAccount().getEmail());

            model.addAttribute("form", form);
            return "/users/register";
        }

        //로그인
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginUser);
        return "redirect:/";
    }

}
