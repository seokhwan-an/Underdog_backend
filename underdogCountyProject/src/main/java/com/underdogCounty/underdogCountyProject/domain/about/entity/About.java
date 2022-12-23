package com.underdogCounty.underdogCountyProject.domain.about.entity;

import com.underdogCounty.underdogCountyProject.domain.about.dto.AboutRequestDto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class About {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;

    @Builder
    public About(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(AboutRequestDto aboutRequestDto){
        this.title = aboutRequestDto.getTitle();
        this.content = aboutRequestDto.getContent();
    }
}
