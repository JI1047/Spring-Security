package com.example.testsecurity.controller;

import com.example.testsecurity.dto.JoinDto;
import com.example.testsecurity.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {

    private final JoinService joinService;

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @GetMapping("/join")
    private String join() {
        return "join";
    }

    @PostMapping("/joinProc")
    public String joinProcess(JoinDto joinDTO) {

        System.out.println(joinDTO.getUsername());

        joinService.joinProcess(joinDTO);


        return "redirect:/login";
    }
}
