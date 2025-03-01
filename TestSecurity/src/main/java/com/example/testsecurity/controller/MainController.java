package com.example.testsecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Iterator;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainP(Model model) {


        String id = SecurityContextHolder.getContext().getAuthentication().getName();

        //사용자의 인증정보 가져옴
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //인증정보 안의 권한 정보를 가져옴
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        //권한 목록이 여러개 일 수 있기 에 Iterator을 사용해 접근
        Iterator<? extends GrantedAuthority> iter = authorities.iterator();

        //첫번쨰 권한 목록 가져옴
        GrantedAuthority auth = iter.next();

//        권한의 문자열 값 불러옴
        String role = auth.getAuthority();

        model.addAttribute("id",id);
        model.addAttribute("role",role);
        return "main";
    }
}
