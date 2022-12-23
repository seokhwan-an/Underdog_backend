package com.underdogCounty.underdogCountyProject.domain.about.dto;

import com.underdogCounty.underdogCountyProject.domain.about.entity.About;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AboutRequestDto {

    private String title;
    private String content;

    @Builder
    public AboutRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public About toEntity(AboutRequestDto aboutRequestDto){
        return About.builder()
            .title(aboutRequestDto.getTitle())
            .content(aboutRequestDto.getContent())
            .build();
    }
}
