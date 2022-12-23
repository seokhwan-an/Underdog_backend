package com.underdogCounty.underdogCountyProject.domain.about.dto;

import com.underdogCounty.underdogCountyProject.domain.about.entity.About;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AboutResponseDto {

    private Long id;
    private String title;
    private String content;

    @Builder
    public AboutResponseDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }


    public static AboutResponseDto toDto(About about){
        return AboutResponseDto.builder()
            .id(about.getId())
            .title(about.getTitle())
            .content(about.getContent())
            .build();
    }

}
