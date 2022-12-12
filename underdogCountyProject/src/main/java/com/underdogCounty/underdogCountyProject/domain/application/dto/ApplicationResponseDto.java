package com.underdogCounty.underdogCountyProject.domain.application.dto;

import com.underdogCounty.underdogCountyProject.domain.application.entity.Application;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ApplicationResponseDto {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String contents;

    @Builder
    public ApplicationResponseDto(Long id, String name, String email, String phoneNumber, String contents) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.contents = contents;
    }

    public static ApplicationResponseDto toDto(Application application){
        return ApplicationResponseDto.builder()
            .id(application.getId())
            .name(application.getName())
            .email(application.getEmail())
            .phoneNumber(application.getPhoneNumber())
            .build();
    }
}
