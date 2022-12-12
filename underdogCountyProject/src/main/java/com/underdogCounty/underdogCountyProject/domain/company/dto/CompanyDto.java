package com.underdogCounty.underdogCountyProject.domain.company.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CompanyDto {

  private Long id;

  private String name;

  private String content;
}
