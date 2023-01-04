package com.underdogCounty.underdogCountyProject.domain.login.controller;

import com.underdogCounty.underdogCountyProject.domain.login.dto.MemberLoginRequestDto;
import com.underdogCounty.underdogCountyProject.domain.login.dto.MemberSignupRequestDto;
import com.underdogCounty.underdogCountyProject.domain.login.dto.TokenInfo;
import com.underdogCounty.underdogCountyProject.domain.login.entity.Member;
import com.underdogCounty.underdogCountyProject.domain.login.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/login")
    public TokenInfo login(@RequestBody MemberLoginRequestDto memberLoginRequestDto) {
        String memberId = memberLoginRequestDto.getMemberId();
        String password = memberLoginRequestDto.getPassword();
        TokenInfo tokenInfo = memberService.login(memberId, password);
        return tokenInfo;
    }

    @PostMapping("/signup")
    public Member signup(@RequestBody MemberSignupRequestDto memberSignupRequestDto){
        return memberService.signup(memberSignupRequestDto);
    }
}
