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
public class ArtistRequestDto {

  private String name;
  private String agency;
  private String contents;
  private String profile;
  private String instarGram;
}
