package com.underdogCounty.underdogCountyProject.domain.work.dto;

import com.underdogCounty.underdogCountyProject.domain.work.Category;
import lombok.Data;

@Data
public class WorkRequestDto {

    private String image;

    private Category category;
}
