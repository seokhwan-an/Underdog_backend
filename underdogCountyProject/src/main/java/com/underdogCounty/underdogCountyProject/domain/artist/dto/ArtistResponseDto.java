package com.underdogCounty.underdogCountyProject.domain.artist.dto;

import com.underdogCounty.underdogCountyProject.domain.artist.entity.Artist;
import lombok.Builder;
import lombok.Data;

@Data
public class ArtistResponseDto {
  private String name;
  private String agency;
  private String contents;

  @Builder
  public ArtistResponseDto entityToResponse(Artist artist){
    ArtistResponseDto result = new ArtistResponseDto();
    result.name = artist.getName();
    result.agency = artist.getAgency();
    result.contents = artist.getContents();
    return result;
  }
}
