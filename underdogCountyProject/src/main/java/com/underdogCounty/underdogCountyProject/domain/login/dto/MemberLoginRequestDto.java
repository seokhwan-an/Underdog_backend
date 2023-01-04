package com.underdogCounty.underdogCountyProject.domain.login.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
public class MemberLoginRequestDto {
    private String memberId;
    private String password;
}
