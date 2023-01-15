package com.underdogCounty.underdogCountyProject.domain.work.dto;

import com.underdogCounty.underdogCountyProject.domain.work.Category;
import com.underdogCounty.underdogCountyProject.domain.work.Work;
import lombok.Data;

@Data
public class WorkResponseDto {
    private Long id;
    private String image;

    private Category category;

    public WorkResponseDto entityToResponse(Work work) {
        WorkResponseDto result = new WorkResponseDto();
        result.id = work.getId();
        result.image = work.getImage();
        result.category = work.getCategory();
        return result;
    }
}
