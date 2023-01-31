package com.underdogCounty.underdogCountyProject.domain.artist.dto;

import com.underdogCounty.underdogCountyProject.domain.artist.entity.Artist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArtistResponseDto {
  private Long id;
  private String name;
  private String agency;
  private String contents;
  private String profile;

  private String instarGram;

  @Builder
  public ArtistResponseDto entityToResponse(Artist artist){
    ArtistResponseDto result = new ArtistResponseDto();
    result.id = artist.getId();
    result.name = artist.getName();
    result.agency = artist.getAgency();
    result.contents = artist.getContents();
    result.profile = artist.getProfile();
    result.instarGram = artist.getInstarGram();
    return result;
  }
}
