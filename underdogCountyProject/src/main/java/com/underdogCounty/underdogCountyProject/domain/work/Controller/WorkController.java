package com.underdogCounty.underdogCountyProject.domain.work.Controller;

import com.underdogCounty.underdogCountyProject.domain.work.Work;
import com.underdogCounty.underdogCountyProject.domain.work.dto.WorkRequestDto;
import com.underdogCounty.underdogCountyProject.domain.work.dto.WorkResponseDto;
import com.underdogCounty.underdogCountyProject.domain.work.service.WorkService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/work")
@RestController
public class WorkController {

    private final WorkService workService;

    @PostMapping()
    public Work create(@RequestBody WorkRequestDto workRequestDto) {
        return workService.create(workRequestDto);
    }

    @GetMapping()
    public List<WorkResponseDto> getAll() {
        return workService.getAll();
    }

    @GetMapping("{id}")
    public WorkResponseDto getOne(@PathVariable Long id) {
        return workService.getOne(id);
    }
}
