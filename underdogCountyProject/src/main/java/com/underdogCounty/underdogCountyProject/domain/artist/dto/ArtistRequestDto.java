package com.underdogCounty.underdogCountyProject.domain.artist.dto;

import com.underdogCounty.underdogCountyProject.domain.artist.entity.Artist;
import lombok.Builder;
import lombok.Data;

@Data
public class ArtistRequestDto {

  private String name;
  private String agency;
  private String contents;
  private String profile;

}
