package com.underdogCounty.underdogCountyProject.domain.login.dto;

import com.underdogCounty.underdogCountyProject.domain.login.entity.Member;
import java.util.List;
import lombok.Data;

@Data
public class MemberSignupRequestDto {
    private String memberId;
    private String password;

    public Member toEntity(){
        return Member.builder()
            .memberId(this.memberId)
            .password(this.password)
            .roles(List.of("USER"))
            .build();
    }

}
