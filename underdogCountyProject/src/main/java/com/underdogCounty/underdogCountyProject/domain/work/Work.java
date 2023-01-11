package com.underdogCounty.underdogCountyProject.domain.work;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.underdogCounty.underdogCountyProject.domain.artist.entity.Artist;
import com.underdogCounty.underdogCountyProject.domain.work.dto.WorkRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Category category;

    @Builder
    public void requestToEntity(WorkRequestDto workRequestDto) {
        this.image = workRequestDto.getImage();
        this.category = workRequestDto.getCategory();
    }

    public Work updateImageUrl(Work work, String imageUrl) {
        this.image = imageUrl;
        return work;
    }

}
