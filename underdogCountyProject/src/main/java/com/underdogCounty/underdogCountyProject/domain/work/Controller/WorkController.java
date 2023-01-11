package com.underdogCounty.underdogCountyProject.domain.work.Controller;

import com.underdogCounty.underdogCountyProject.domain.work.Work;
import com.underdogCounty.underdogCountyProject.domain.work.dto.WorkRequestDto;
import com.underdogCounty.underdogCountyProject.domain.work.service.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("api/work")
@Controller
public class WorkController {

    private final WorkService workService;

    @PostMapping()
    public Work create(@RequestBody WorkRequestDto workRequestDto) {
        return workService.create(workRequestDto);
    }

}
