package com.underdogCounty.underdogCountyProject.domain.application.dto;

import com.underdogCounty.underdogCountyProject.domain.application.entity.Application;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
public class ApplicationRequestDto {
    private String name;
    private String email;
    private String phoneNumber;
    private String contents;

    @Builder
    public ApplicationRequestDto(String name, String email, String phoneNumber, String contents) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.contents = contents;
    }

    public static Application toEntity(ApplicationRequestDto applicationRequestDto){
        return Application.builder()
            .name(applicationRequestDto.name)
            .email(applicationRequestDto.email)
            .phoneNumber(applicationRequestDto.phoneNumber)
            .contents(applicationRequestDto.contents)
            .build();
    }
}
