package com.underdogCounty.underdogCountyProject.domain.artist.entity;

import com.underdogCounty.underdogCountyProject.domain.artist.dto.ArtistRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    private String instarGram;

    @Builder
    public void requestToEntity(ArtistRequestDto artistRequestDto){
        this.name = artistRequestDto.getName();
        this.agency = artistRequestDto.getAgency();
        this.contents = artistRequestDto.getContents();
        this.profile = artistRequestDto.getProfile();
        this.instarGram = artistRequestDto.getInstarGram();
    }

    public Artist updateImageUrl(Artist artist, String imageUrl) {
        this.profile = imageUrl;
        return artist;
    }

    public Artist deleteImageUrl(Artist artist) {
        this.profile = null;
        return artist;
    }
}
