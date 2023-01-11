package com.underdogCounty.underdogCountyProject.domain.artist.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.underdogCounty.underdogCountyProject.domain.artist.dto.ArtistRequestDto;
import com.underdogCounty.underdogCountyProject.domain.work.Work;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String agency;

    @NotNull
    private String contents;

    private String profile;

    @Builder
    public void requestToEntity(ArtistRequestDto artistRequestDto){
        this.name = artistRequestDto.getName();
        this.agency = artistRequestDto.getAgency();
        this.contents = artistRequestDto.getContents();
        this.profile = artistRequestDto.getProfile();
    }

    public Artist updateImageUrl(Artist artist, String imageUrl) {
        this.profile = imageUrl;
        return artist;
    }
}
